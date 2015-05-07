package edu.brandeis.flow.server.source;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Streamer {
	private final ServerSocket socket;
	private Socket client;
	private PrintWriter out;

	public Streamer(int port) throws IOException {
		this.socket = new ServerSocket(port);
	}

	public void send(String s) throws IOException {
		client = socket.accept();
		// Wait for a client to connect. The method will block;
		// when it returns the socket will be connected to the client

		// Get input and output streams to talk to the client
		out = new PrintWriter(client.getOutputStream(), true);

		out.print(s);

		out.close(); // Flush and close the output stream
		client.close(); // Close the socket itself
	}
}
