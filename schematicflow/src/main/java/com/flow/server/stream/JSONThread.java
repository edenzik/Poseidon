/**
 * 
 */
package com.flow.server.stream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import edu.brandeis.flow.core.operator.In;

/**
 * @author Yahui
 *
 */
public final class JSONThread extends Thread{

	In in;
	/**
	 * 
	 */
	public JSONThread(In in) {
		this.in = in;
	}
	
	@Override
	public void run() {
        JSONStream inStream = null;
		try {
			inStream = new JSONStream("localhost", 5050);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        while(true) {
        	//read
        	JSONObject json = null;
			try {
				if((json = inStream.read()) != null) in.receive(json);
			} catch (JSONException | IOException e) {
				e.printStackTrace();
			}
			//sleep
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
		
    }
//
//	public static void main(String[] args) throws JSONException, IOException {
//		JSONThread t = new JSONThread(new In());
//		t.start();
//	}
}
