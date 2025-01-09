import java.io.*;
import java.net.*;

public class Examples10Server {

    public static void main(String[] args) throws IOException {

        // jednoduchy server
        try (ServerSocket s = new ServerSocket(6666)) {
            System.out.println("Server ready");
            try (Socket socket = s.accept()) {
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                while (true) {
                    // ...
                    in.read();
                    // ...
                    out.write(12345);
                    // ...
                }
            }
        }
    }
}
