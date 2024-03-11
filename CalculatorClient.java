package SocketStuff;

import java.io.*;
import java.net.*;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        Socket sock = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            sock = new Socket("127.0.0.1", 5155);
            out = new PrintWriter(sock.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            // Prepare an example operation, e.g., "add 10 20"
            String operation = "add 10 20";
            System.out.println("Sending to server: " + operation);
            out.println(operation);

            // Read the response from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: 127.0.0.1.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: 5155.");
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (sock != null) {
                sock.close();
            }
        }
    }
}

