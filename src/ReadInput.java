import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) throws IOException {

        /*
        // Creating a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Reading a line of text from the user
        System.out.print("Enter a line of text: ");
        String userInput = scanner.nextLine();
        System.out.println("You entered: " + userInput);

        // Reading an integer from the user
        System.out.print("Enter an integer: ");
        int userInt = scanner.nextInt();
        System.out.println("You entered: " + userInt);

        // Reading a double from the user
        System.out.print("Enter a double: ");
        double userDouble = scanner.nextDouble();
        System.out.println("You entered: " + userDouble);

        // Remember to close the Scanner to free up resources
        scanner.close();
        */


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { // dolezity riadok
            String line;

            // Read lines using a while loop, ak iba raz, bez while...
            while (!(line = reader.readLine()).equals("\n")) {
                System.out.println("You entered: " + line);
                // Add your processing logic for each line here
            }
        }
    }
}
