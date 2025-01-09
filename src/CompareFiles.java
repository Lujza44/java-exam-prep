import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CompareFiles {

    public static void main(String[] args) throws IOException {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        if (!file1.isFile() || !file2.isFile()) {
            throw new IllegalArgumentException("One of the files (or both) is not a file or doesn't exist.");
        }

        if (file1.length() == 0 && file2.length() == 0) {
            System.out.println("YES");
            return;
        }

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            compareFiles(reader1, reader2);
        }
    }

    public static void compareFiles(BufferedReader reader1, BufferedReader reader2) throws IOException{

        int character1;
        boolean same = false;

        while((character1 = reader1.read()) != -1) {
            if (character1 == reader2.read()) {
                same = true;
            } else {
                same = false;
                break;
            }
        }

        printResult(same);
    }

    public static void printResult(boolean same) {
        if (same) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
