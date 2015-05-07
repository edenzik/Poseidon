package edu.brandeis.flow.server.source.twitter;

import java.io.IOException;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterObjectFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import edu.brandeis.flow.server.source.Streamer;
import edu.brandeis.flow.ui.callback.Callback;

public final class TwitterStreamSource {

	public ConfigurationBuilder cb = new ConfigurationBuilder();
	public TwitterStream twitterStream;
	public StatusListener listener;
	public final Streamer streamer;

	public TwitterStreamSource() throws Exception {
		setUpBuilder();
		streamer = new Streamer(5050);
		twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		setUpListener();
		twitterStream.addListener(listener);
		twitterStream.sample();
	}

	public void setUpBuilder() {
		cb.setDebugEnabled(false)
				.setOAuthConsumerKey("OiXPmaK5iF9InAsjUY3cpAIBi")
				.setJSONStoreEnabled(true)
				.setOAuthConsumerSecret(
						"nDbaKfCzh7gnxsVqVGihd3GwkbIGqAmxsejgwsrNo4XaEum772")
				.setOAuthAccessToken(
						"3018770327-MdYABjcFvagY2yNQnjoUEOuUwM9QfwafnjbTP9v")
				.setOAuthAccessTokenSecret(
						"6y5vUF8TLfRC6P8tNiD1KeDNnzeBYzYNxnx12NqIEQkAv");
	}

	public void setUpListener() {
		listener = new StatusListener() {

			@Override
			public void onException(Exception arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice arg0) {
				// System.out.println("Deletion notice from" +
				// arg0.getUserId());

			}

			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStatus(Status arg0) {
				// TwitterStreamFactor.getRawJSON(arg0.getTw)


			}

			@Override
			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub

			}
		};
	}

}