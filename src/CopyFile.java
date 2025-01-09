import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        File source = new File(args[0]);
        File target = new File(args[1]);

        Files.copy(source.toPath(), target.toPath());

    }
}
