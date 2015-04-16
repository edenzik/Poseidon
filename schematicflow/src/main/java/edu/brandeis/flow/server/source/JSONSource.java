package edu.brandeis.flow.server.source;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class JSONSource implements Runnable{
	URL url;
	public final Streamer streamer;
	public InputStream input;
	public BufferedReader in;

	public JSONSource(URL url, int port) throws IOException  {
		this.url = url;
		streamer = new Streamer(port);
		
		//open and get connection to the url
		URLConnection connection = url.openConnection();
		in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	
	}
	@Override
	public void run() {
		String inputLine;
		try {
			while((inputLine = in.readLine())!= null) {
				streamer.send(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) throws MalformedURLException, Exception {
//			JSONSource test = new JSONSource(new URL("http://echo.jsontest.com/insert-key-here/insert-value-here/two/one"), 
//					6000);
//		
//	}
	
	

}
