import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
public final class PrintSampleStream {
    
    public static void main(String[] args) throws TwitterException {
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("OiXPmaK5iF9InAsjUY3cpAIBi")
          .setOAuthConsumerSecret("nDbaKfCzh7gnxsVqVGihd3GwkbIGqAmxsejgwsrNo4XaEum772")
          .setOAuthAccessToken("3018770327-MdYABjcFvagY2yNQnjoUEOuUwM9QfwafnjbTP9v")
          .setOAuthAccessTokenSecret("6y5vUF8TLfRC6P8tNiD1KeDNnzeBYzYNxnx12NqIEQkAv");
        
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        StatusListener listener = new StatusListener(){

			public void onException(Exception arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onDeletionNotice(StatusDeletionNotice arg0) {
				//System.out.println("Deletion notice from" + arg0.getUserId());
				
			}

			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}

			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onStatus(Status arg0) {
				System.out.println ("Tweet From: " + arg0.getUser().getScreenName() + " Says: "+ arg0.getText());
				
			}

			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub
				
			}};
        twitterStream.addListener(listener);
        twitterStream.sample();
    }
}