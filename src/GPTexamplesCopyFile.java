import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class GPTexamplesCopyFile {

    public static void main(String[] args) throws IOException {
        String sourceFilePath = "path/to/source/file.txt";
        String destinationFilePath = "path/to/destination/file.txt";


        // Open the source file channel in read mode
        try (FileInputStream sourceFile = new FileInputStream(sourceFilePath);
             FileChannel sourceChannel = sourceFile.getChannel()) {

            // Open the destination file channel in write mode
            try (FileOutputStream destinationFile = new FileOutputStream(destinationFilePath);
                 FileChannel destinationChannel = destinationFile.getChannel()) {

                // Use transferFrom to copy data from the source channel to the destination channel
                destinationChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

                // Alternatively, you can use transferTo
                // sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
            }

            System.out.println("File copied successfully!");
        }
    }
}
