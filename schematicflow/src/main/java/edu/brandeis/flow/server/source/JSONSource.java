package edu.brandeis.flow.server.source;

import edu.brandeis.flow.server.source.twitter.TwitterStreamSource;

public class JSONSource {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new
		// FileReader("twitter_source.json"));
		// Streamer streamer = new Streamer(5050);
		// String json;
		// while ((json = br.readLine()) != null){
		// streamer.send(json);
		// }

		TwitterStreamSource twitter = new TwitterStreamSource();

	}
}
