import javax.print.attribute.standard.PrinterName;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
    public static File file;

    public static void main(String[] args) throws IOException {

        file = new File("file.txt").getAbsoluteFile().getCanonicalFile();

        System.out.println(file.getAbsolutePath());

        // jednoduchy server
        try (ServerSocket s = new ServerSocket(6666)) { // najprv vytvorim server socket
            System.out.println("Server ready");

            while (true) { // server musi stale bezat
                System.out.println("listening");
                try (Socket socket = s.accept()) { // zacne pocuvat na sockete
                    System.out.println("Client connected.");
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // input servera
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // output servera

                    String command = in.readLine();

                    evalUserInput(command);

                    System.out.println("Command recieved: " + command);
                    out.println("Echo from server: " + command);
                    System.out.println("Echo sent.");

                }
            }
        }
    }

    public static void evalUserInput(String command) throws IOException{
        String[] params = command.split(" ",3);

        switch (params[0]) {
            case "-a" -> appendMessage(file, Integer.parseInt(params[1]), params[2]); // viacslovna sprava sa musi zadavat v " "
            case "-l" -> listMessagesL(file);
            case "-r" -> listMessagesR(file);
            case "-d" -> deleteMessage(file);
            default -> System.out.println("Nespravne zadane parametre!");
        }
    }
    private static void appendMessage(File file, int priority, String text) throws IOException {
        Msg msg = new Msg(priority, text);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(msg.toString());
            writer.newLine();
        }
    }

    private static List<Msg> readFromFile(File file) throws IOException {
        List<Msg> msgs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                int prior = Integer.parseInt(parts[0]);
                String text = parts[1];
                msgs.add(new Msg(prior, text));
            }
        }
        return msgs;
    }

    private static void listMessagesL(File file) throws IOException {
        List<Msg> list = readFromFile(file);
        list.sort(Collections.reverseOrder()); // od najvacsej priority
        for (Msg msg : list) {
            System.out.println(msg);
        }
    }

    private static void listMessagesR(File file) throws IOException {
        List<Msg> list = readFromFile(file);
        Collections.sort(list); // od najmensej priority
        for (Msg msg : list) {
            System.out.println(msg);
        }
    }

    private static void deleteMessage(File file) throws IOException {
        List<Msg> list = readFromFile(file);
        if (list.isEmpty()) {
            System.out.println("Zoznam je prazdny.");
            return;
        }
        int i = 1;
        for (Msg msg : list) {
            System.out.println(i + " " + msg);
            i++;
        }
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Zadajte poradove cislo spravy, ktoru chcete zmazat: ");
            int lineToDelete = Integer.parseInt(inputReader.readLine()) - 1;
            list.remove(lineToDelete);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Msg line : list) {
                writer.write(line.toString());
                writer.newLine();
            }
        }
    }
}



class Msg implements Comparable<Msg> {


    private final int priority;
    private final String text;

    public Msg(int priority, String text) {
        this.priority = priority;
        this.text = text;
    }

    @Override
    public int compareTo(Msg otherMessage) {
        return Integer.compare(this.priority, otherMessage.priority);
    }

    @Override
    public String toString() {
        return this.priority + " " + this.text;
    }

}