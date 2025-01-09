import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Message implements Comparable<Message> {

    public static void main(String[] args) throws IOException {

        String filePath = "file.txt";

        switch (args[0]) {
            case "-a" ->
                    appendMessage(filePath, Integer.parseInt(args[1]), args[2]); // viacslovna sprava sa musi zadavat v " "
            case "-l" -> listMessagesL(filePath);
            case "-r" -> listMessagesR(filePath);
            case "-d" -> deleteMessage(filePath);
            default -> System.out.println("Nespravne zadane parametre!");
        }
    }

    private final int priority;
    private final String text;

    public Message(int priority, String text) {
        this.priority = priority;
        this.text = text;
    }

    @Override
    public int compareTo(Message otherMessage) {
        return Integer.compare(this.priority, otherMessage.priority);
    }

    @Override
    public String toString() {
        return this.priority + " " + this.text;
    }

    private static void appendMessage(String filePath, int priority, String text) throws IOException {
        Message msg = new Message(priority, text);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(msg.toString());
            writer.newLine();
        }
    }

    private static List<Message> readFromFile(String file) throws IOException {
        List<Message> msgs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                int prior = Integer.parseInt(parts[0]);
                String text = parts[1];
                msgs.add(new Message(prior, text));
            }
        }
        return msgs;
    }

    private static void listMessagesL(String filePath) throws IOException {
        List<Message> list = readFromFile(filePath);
        list.sort(Collections.reverseOrder()); // od najvacsej priority
        for (Message msg : list) {
            System.out.println(msg);
        }
    }

    private static void listMessagesR(String filePath) throws IOException {
        List<Message> list = readFromFile(filePath);
        Collections.sort(list); // od najmensej priority
        for (Message msg : list) {
            System.out.println(msg);
        }
    }

    private static void deleteMessage(String filePath) throws IOException {
        List<Message> list = readFromFile(filePath);
        if (list.isEmpty()) {
            System.out.println("Zoznam je prazdny.");
            return;
        }
        int i = 1;
        for (Message msg : list) {
            System.out.println(i + " " + msg);
            i++;
        }
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Zadajte poradove cislo spravy, ktoru chcete zmazat: ");
            int lineToDelete = Integer.parseInt(inputReader.readLine()) - 1;
            list.remove(lineToDelete);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Message line : list) {
                writer.write(line.toString());
                writer.newLine();
            }
        }
    }
}
