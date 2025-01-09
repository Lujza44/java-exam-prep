import java.io.*;

public class BlockAlignment {

    public static void main(String[] args) throws IOException {

        File file = new File(args[0]); // meno suboru
        int length = Integer.parseInt(args[1]); // dlzka riadku

        if (!file.isFile()) {
            throw new IllegalArgumentException(file.getAbsolutePath() + "is not a file or doesn't exist.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            processFile(reader, length);
        }
    }

    public static boolean isWhitespace(int ch) {
        return ch == 32 || ch == 9 || ch == 10 || ch == 13;
    }

    public static void processFile(BufferedReader reader, int length) throws IOException {
        int character;
        int wsCounter = 0;
        StringBuilder word = new StringBuilder("");
        StringBuilder line = new StringBuilder("");

        while ((character = reader.read()) != -1) {
            // precitam character, ak je ws, zvysim counter, inak appendnem do slova
            if (!isWhitespace(character)) {
                word.append((char) character);
            } else {
                wsCounter++;
            }
            // ak som nacitala nejaky ws a slovo nie je prazdne, appednenm ho na riadok ak sa zmesti
            if (wsCounter > 0 && !word.isEmpty()) {
                if (line.length() + word.length() <= length) {
                    line.append(word + " ");
                    word.setLength(0);
                    wsCounter = 0;
                } else {
                    System.out.println(line);
                    line.setLength(0);
                    line.append(word + " ");
                    word.setLength(0);
                    wsCounter = 0;
                }
            }
        }
    }
}
