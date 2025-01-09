import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GPTImageDownloader {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GPTImageDownloader <url>");
            return;
        }

        String url = args[0];

        try {
            // Stáhnout HTML obsah stránky
            String htmlContent = downloadHtml(url);
            // Extrahovat URL obrázků z HTML obsahu
            Set<String> imageUrls = extractImageUrls(htmlContent);
            // Stáhnout každý obrázek
            downloadImages(imageUrls);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String downloadHtml(String url) throws IOException {
        URL website = new URL(url);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()))) {
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            return content.toString();
        } // toto uklada cely obsah stranky do jedneho sb?? je to ok?
    }

    private static Set<String> extractImageUrls(String htmlContent) {
        Set<String> imageUrls = new HashSet<>();
        Pattern pattern = Pattern.compile("<img\\s+src=\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(htmlContent);
        while (matcher.find()) {
            String imageUrl = matcher.group(1);
            imageUrls.add(imageUrl);
        }
        return imageUrls;
    }

    private static void downloadImages(Set<String> imageUrls) throws IOException {
        for (String imageUrl : imageUrls) {
            URL url = new URL(imageUrl);
            try (InputStream in = url.openStream()) {
                // Získání názvu souboru z URL
                String fileName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
                // Stáhnutí obrázku do aktuálního adresáře
                Path outputPath = Path.of(fileName);
                Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Staženo: " + fileName);
            }
        }
    }
}
