import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

    public static void main(String[] args) throws IOException {

        //jednoduchy klient
        InetAddress addr = InetAddress.getByName("localhost");
        int port = 6666;

        while (true) { // znovu a znovu sa bude klient pripajat
            try (Socket socket = new Socket(addr, port)) { // na tento socket

                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); // citanie inputu od usera
                PrintWriter serverInput = new PrintWriter(socket.getOutputStream(), true); // klient pise serveru
                BufferedReader serverOutput = new BufferedReader(new InputStreamReader(socket.getInputStream())); // citanie server outputu

                System.out.print("Enter a command: ");
                String command = userInput.readLine();
                serverInput.println(command);
                String serverResponse = serverOutput.readLine();
                System.out.println("Server odpovedal: " + serverResponse); // vypisujem userovi

            }
        }
    }
}