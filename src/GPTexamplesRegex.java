import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GPTexamplesRegex {
    public static void main(String[] args) {
        // Sample text containing email addresses
        String text = "This is a sample text with email addresses: " +
                "user1@example.com, user2@gmail.com, and admin@company.com";

        // Regular expression for matching email addresses
        String emailRegex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        // Create a Pattern object
        Pattern pattern = Pattern.compile(emailRegex);
        // Create a Matcher object
        Matcher matcher = pattern.matcher(text);

        // Find and print all email addresses in the text
        while (matcher.find()) {
            String email = matcher.group();
            System.out.println("Found email: " + email);
        }
    }
}
