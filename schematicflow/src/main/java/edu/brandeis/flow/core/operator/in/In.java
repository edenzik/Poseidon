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
	String source = "";
	public In(String name, String sr) throws JSONException, IOException {
		super(name);
<<<<<<< HEAD
=======
		//feed JSON from its source(e.g. twitter/url) to server
		source = sr;
		new Thread(new JSONSource(source)).start();
		
		//feed JSON from server to In
		JSONThread thread = new JSONThread(this);
		thread.start();
>>>>>>> e9b7f754e8d145714da9c88418132e1d65f4dfc0
	}
	

	public In(String sr) throws JSONException, IOException {
		this("In", sr);
	}

	@Override
	public void process() {
<<<<<<< HEAD
		
	}

=======

		while (true) {
			JSONObject top;
			if ((top = read()) != null) {
				System.out.println("IN:::" + top);
				send(top);

			}

		}
	}
>>>>>>> e9b7f754e8d145714da9c88418132e1d65f4dfc0
	
	protected void setSource(String s) {
		this.source = s;
	}

	// public static void main(String[] args) throws Exception {
	// In test = new In("test");
	// test.process();
	// }
	//
}
