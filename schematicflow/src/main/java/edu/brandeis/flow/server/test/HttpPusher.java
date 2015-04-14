package edu.brandeis.flow.server.test;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import org.json.JSONObject;

public class HttpPusher {
	public static void main(String args[]) {
		try {

			Random randomGenerator = new Random();
			// Get the port to listen on
			int port = Integer.parseInt(args[0]);
			// Create a ServerSocket to listen on that port.
			ServerSocket ss = new ServerSocket(port);

			// Now enter an infinite loop, waiting for & handling connections.

			for (;;) {
				Socket client = ss.accept();
				// Wait for a client to connect. The method will block;
				// when it returns the socket will be connected to the client

				// Get input and output streams to talk to the client
				PrintWriter out = new PrintWriter(client.getOutputStream(),
						true);

				// Now, read the HTTP request from the client, and send it
				// right back to the client as part of the body of our
				// response. The client doesn't disconnect, so we never get
				// an EOF. It does sends an empty line at the end of the
				// headers, though. So when we see the empty line, we stop
				// reading. This means we don't mirror the contents of POST
				// requests, for example. Note that the readLine() method
				// works with Unix, Windows, and Mac line terminators.
				// string line;
				System.out.println("RECIEVED REQUESTED");
				JSONObject j = new JSONObject();
				j.put("random", randomGenerator.nextInt(1000000));
				out.print(j.toString());
				// while ((line = in.readline()) != null) {
				// if (line.length() == 0)
				// break;
				// out.print("poop");//line + "\r\n");
				// system.out.println(line);
				// }

				// Close socket, breaking the connection to the client, and
				// closing the input and output streams
				out.close(); // Flush and close the output stream
				client.close(); // Close the socket itself
			} // Now loop again, waiting for the next connection
		}
		// If anything goes wrong, print an error message
		catch (Exception e) {
			System.err.println(e);
			System.err.println("Usage: java HttpMirror <port>");
		}
	}
}