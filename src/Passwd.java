import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passwd {
    public static void main(String[] args) throws IOException {
        String input;

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter login you want to add:");

            input = inputReader.readLine();
        }

        File file = new File("password.txt");

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {

            addUser(fileReader, input);
        }
    }

    public static void addUser(BufferedReader fileReader, String login) throws IOException{
        String patternString = "^" + login + ":.*";
        Pattern pattern = Pattern.compile(patternString);

        String line;
        int lineNumber = 0;

        while ((line = fileReader.readLine()) != null) {
            lineNumber++;

            Matcher matcher = pattern.matcher(line);

            if (matcher.matches()) {
                System.out.println("This login already exists.");
                return;
            }
        }

        // pridat uzivatela so zadanym loginom

    }
}
