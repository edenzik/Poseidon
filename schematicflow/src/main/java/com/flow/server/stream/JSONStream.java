/**
 * 
 */
package com.flow.server.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.ui.Label;

/**
 * @author edenzik
 *
 */
public final class JSONStream extends URLStream {
	
	public JSONStream(String url, int port) throws MalformedURLException{
		super(url, port);
	}
	
	public JSONObject readJSON() throws JSONException, IOException{
		String nextLine = readNext();
		if (nextLine == null) return null;
		return new JSONObject(nextLine);
		//JSONObject val = (nextLine != null) ? new JSONObject(readNext()) : null;
		//return val;
	}
	
}
