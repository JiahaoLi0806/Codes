package SocketStuff;

import java.io.*;
import java.net.*;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            serverSocket = new ServerSocket(5155);
            System.out.println("Calculator Server started. Listening on port 5155.");

            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String result = calculate(inputLine);
                out.println(result);
            }

        } catch (IOException e) {
            System.err.println("Could not listen on port: 5155.");
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static String calculate(String input) {
        try {
            String[] parts = input.split(" ");
            String operation = parts[0];
            double number1 = Double.parseDouble(parts[1]);
            double number2 = Double.parseDouble(parts[2]);

            switch (operation) {
                case "add":
                    return String.valueOf(number1 + number2);
                case "subtract":
                    return String.valueOf(number1 - number2);
                case "multiply":
                    return String.valueOf(number1 * number2);
                case "divide":
                    if (number2 == 0) throw new IllegalArgumentException("Cannot divide by zero.");
                    return String.valueOf(number1 / number2);
                default:
                    return "Error: Invalid operation.";
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
