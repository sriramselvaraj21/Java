package multithreaded_chat;

import java.net.Socket;

import java.io.*;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 4000);
		BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream outgoing = new PrintStream(socket.getOutputStream());
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String message;

		while (true) {
			System.out.println("Client : ");
			message = input.readLine();
			outgoing.println(message);
			if (message.equalsIgnoreCase("bye")) {
				System.out.println("Got to go...bye!!!");
				break;
			}
			message = incoming.readLine();
			System.out.println("Server says, " + message);
			System.out.println();
		}

		socket.close();
		incoming.close();
		outgoing.close();
		input.close();
	}
}
