package com.flow.server.source;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONSource {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("twitter_source.json"));
		Streamer streamer = new Streamer(5050);
		String json;
		while ((json = br.readLine()) != null){
			streamer.send(json);
		}
	}
}
