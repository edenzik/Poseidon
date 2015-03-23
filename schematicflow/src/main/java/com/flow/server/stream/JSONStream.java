/**
 * 
 */
package com.flow.server.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.ui.Label;

/**
 * @author edenzik
 *
 */
public final class JSONStream{
	private final int port;
	private final String url;
	private Socket socket;
	
	public JSONStream(String url, int port) throws MalformedURLException{
		this.port = port;
		this.url = url;
	}
	
	public Set<JSONObject> read() throws JSONException, IOException{
		socket = new Socket("localhost", port);
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Set<JSONObject> result = new HashSet<JSONObject>();
		String val;
		while ((val = is.readLine()) != null){
			result.add(new JSONObject(val));
		}
		return result;
	}
	
}
