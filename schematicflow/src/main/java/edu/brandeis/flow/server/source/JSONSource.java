package edu.brandeis.flow.server.source;

import edu.brandeis.flow.server.source.twitter.TwitterStreamSource;

public class JSONSource implements Runnable{
//	public static void main(String[] args) throws Exception {
//		// BufferedReader br = new BufferedReader(new
//		// FileReader("twitter_source.json"));
//		// Streamer streamer = new Streamer(5050);
//		// String json;
//		// while ((json = br.readLine()) != null){
//		// streamer.send(json);
//		// }
//		
//		
//		TwitterStreamSource twitter = new TwitterStreamSource();
//
//	}

	String source;
	public JSONSource(String source) {
		this.source = source;
	}
	
	@Override
	public void run() {
		if(source.equals("twitter")) {
			try {
				TwitterStreamSource twitter = new TwitterStreamSource();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			//if the source is not twiitter, e.g. url
		}
		
	}
}
