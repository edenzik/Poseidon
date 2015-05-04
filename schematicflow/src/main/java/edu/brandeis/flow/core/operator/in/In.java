package edu.brandeis.flow.core.operator.in;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.annotations.Push;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.server.source.JSONSource;
import edu.brandeis.flow.server.stream.JSONThread;

/**
 * 
 * @author Yahui
 *
 */
@Push
public class In extends JSONOperator {
	int port;
	URL url;
	
	public In() {
		super();
	}
	public void setURL(String url, int port) throws MalformedURLException {
		this.port = port;
		this.url = new URL(url);
	}
	
	public void startRequest() throws IOException {
		//start source server
		JSONSource source = new JSONSource(this.url, port);
		new Thread(source).start();

		//read from the source server
		JSONThread thread = new JSONThread(this, port);
		thread.start();		
	}


	@Override
	public void run() {
		while (true) {
			try {
				JSONObject response = Unirest.get("http://localhost:4567")
				  .queryString("name", "Mark")
				  .asJson().getBody().getObject();
				//System.out.println(response);
				send(response);
			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
