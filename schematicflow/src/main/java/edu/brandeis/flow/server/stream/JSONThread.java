/**
 * 
 */
package edu.brandeis.flow.server.stream;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;
import edu.brandeis.flow.core.json.JSONObject;

import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author Yahui
 *
 */
public final class JSONThread extends Thread {

	JSONOperator op;
	int port;

	/**
	 * 
	 */
	public JSONThread(JSONOperator op, int port) {
		this.op = op;
		this.port = port;
	}

	@Override
	public void run() {
		JSONStream inStream = null;
		try {
			inStream = new JSONStream("localhost", port);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		while (true) {
			// read
			JSONObject json = null;
			try {
				if ((json = (JSONObject) inStream.read()) != null)
					op.receive(json);
			} catch (JSONException | IOException e) {
				e.printStackTrace();
			}

		}

	}
	//
	// public static void main(String[] args) throws JSONException, IOException
	// {
	// JSONThread t = new JSONThread(new In());
	// t.start();
	// }
}
