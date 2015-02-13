package com.flow.server.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

class URLStream extends Stream {
	private final URL source;
	private BufferedReader reader = null;
	
	protected URLStream(URL url) throws MalformedURLException{
		this.source = url;
	}
	
	public URLStream(String url, int port) throws MalformedURLException{
		this(new URL("http", url, port, ""));
	}
	
	public void startRead() throws IOException{
		this.reader = 	new BufferedReader(
						new InputStreamReader(source.openStream()));
	}
	
	public void endRead() throws IOException{reader.close();}
	
	public String readNext() throws IOException{return reader.readLine();}
	
}
