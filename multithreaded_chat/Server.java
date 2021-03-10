package multithreaded_chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server {
	int port;
	ServerSocket server = null;
	Socket client = null;
	ExecutorService pool = null;
	int clientCount = 0;

	public static void main(String[] args) throws Exception {
		Server serverObject = new Server(4000);
		serverObject.startServer();
	}

	public Server(int i) {
		// this.port = port;
		pool = Executors.newFixedThreadPool(5);
	}

	public void startServer() throws Exception {
		server = new ServerSocket(4000);
		System.out.println("Server Booted");
		System.out.println("say BYE to end...");
		while (true) {
			client = server.accept();
			clientCount++;
			ServerThread run = new ServerThread(client, clientCount, this);
			pool.execute(run);
		}
	}

	private static class ServerThread implements Runnable {
		Server server = null;
		Socket client = null;
		BufferedReader incoming;
		PrintStream outgoing;
		int id;
		String message;
		Scanner sc = new Scanner(System.in);

		public ServerThread(Socket client, int clientCount, Server server) throws Exception {
			this.client = client;
			this.server = server;
			this.id = clientCount;

			System.out.println(client + "got connected, say hi !......id :- " + id);
			incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));
			outgoing = new PrintStream(client.getOutputStream());
		}

		@Override
		public void run() {
			int temp = 1;
			try {
				while (true) {
					message = incoming.readLine();
					System.out.println("Client " + id + "says," + message);
					System.out.println();
					message = sc.nextLine();
					if (message.equalsIgnoreCase("bye")) {
						outgoing.println("bye....");
						temp = 0;
						break;
					}
					outgoing.println(message);
				}
				incoming.close();
				outgoing.close();
				client.close();
				if (temp == 0) {
					System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
