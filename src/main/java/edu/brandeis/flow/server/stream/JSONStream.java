/**
 * 
 */
package edu.brandeis.flow.server.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author edenzik
 *
 */
public final class JSONStream {
	private final int port;
	private final String url;
	private Socket socket;

	public JSONStream(String url, int port) throws MalformedURLException {
		this.port = port;
		this.url = url;
	}

	public JSONObject read() throws JSONException, IOException {
		
		try {
			socket = new Socket("localhost", port);
			BufferedReader is = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String val;
			
			if ((val = is.readLine()) != null)
				return new JSONObject(val);
			
		}catch (ConnectException e) {
			
		}catch (JSONException ee) {
			System.out.println("not a json error");
		}
		return null;
		
	}

}
