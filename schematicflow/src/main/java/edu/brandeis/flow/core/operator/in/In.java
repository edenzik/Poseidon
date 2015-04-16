package edu.brandeis.flow.core.operator.in;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

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
	public In() throws JSONException, IOException {
		super();
	}


	@Override
	public void run() {
		
		while (true) {
			JSONObject top = new JSONObject();
			try {
				top.append("hello", "world");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("IN:::" + top);
			send(top);
		}
		
//		int i = 0;
//		 while (i<100000) {
//			 //System.out.println("mooo loo");
//			 try {
//				 i++;
//				 JSONObject ob = new JSONObject();
//				 ob.append("some key", "some val");
//				 send(ob);
//				 Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//         }
	}

}
