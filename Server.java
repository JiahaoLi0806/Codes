package SocketStuff;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;

        try {
            // Create a new ServerSocket to listen on port 5155
            serverSocket = new ServerSocket(5155);
            System.out.println("Server started. Listening on port 5155.");

            // Accept a connection from the client
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Set up output stream to send data to the client
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send a personal message to the client
            out.println("Hello, this is a message from the server!");

        } catch (IOException e) {
            System.err.println("Could not listen on port: 5155.");
            System.exit(1);
        } finally {
            // Close the streams and sockets
            if (out != null) {
                out.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
