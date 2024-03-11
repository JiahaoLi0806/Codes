package SocketStuff;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	//This is the main method of the program, which is the entry point for execution. It throws an IOException, which means it's declaring that this method might cause an input/output error that it does not handle itself.
	public static void main(String[] args) throws IOException {
		
		//These lines declare variables to handle the input stream, a buffered reader to read from the stream, and the socket for network communication, initializing them to null.
		InputStream in = null;
		BufferedReader bin = null;
		Socket sock = null;
		
		//This block is used to handle exceptions that might be thrown during the execution of the code within the try block. It catches IOExceptions and prints the error to the standard error stream. The finally block ensures that the socket is closed when the try-catch block is finished executing.
		try {
			//This line creates a new Socket object that attempts to connect to the local machine (127.0.0.1 is the loopback address) on port 5155.
			sock = new Socket("127.0.0.1", 5155);
			
			//These lines get the input stream from the socket and wrap it in a BufferedReader for efficient reading.
			in = sock.getInputStream();
			bin = new BufferedReader(new InputStreamReader(in));
			
			//This loop reads each line of text from the buffered reader (which, in turn, is reading from the input stream of the socket) until there is no more data (when readLine() returns null). Each line is then printed to the console.
			String line;
			
			while((line = bin.readLine()) != null) {
			    System.out.println(line);
			}

		} catch(IOException ioe) {
		    System.err.println(ioe);
		    
		} finally {
			//This line is in the finally block to ensure that the socket is closed even if an exception occurs. It prevents resource leaks by closing the network connection.
			if (sock != null) {
				
			    sock.close();
			}

		}


	}

}
