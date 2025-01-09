import java.io.*;
import java.net.*;

public class Examples10Client {

    public static void main(String[] args) throws IOException {

        //jednoduchy klient
        InetAddress addr = InetAddress.getByName(null);
        Socket socket = new Socket(addr, 6666);
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {
            while (true) {
                out.write(12345);
                //...
                in.read();
                //...
            }
            //...

        }
    }
}