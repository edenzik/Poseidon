package edu.brandeis.flow.core.operator.in;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.annotations.Push;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.server.stream.JSONThread;

/**
 * 
 * @author Yahui
 *
 */
@Push
public class In extends JSONOperator {
	public In(String name) throws JSONException, IOException {
		super(name);
		JSONThread thread = new JSONThread(this);
		thread.start();
	}

	public In() throws JSONException, IOException {
		this("In");
	}

	@Override
	public void process() {

		while (true) {
			JSONObject top;
			if ((top = read()) != null) {
				// System.out.println(top);
				send(top);

			}

		}
	}

	// public static void main(String[] args) throws Exception {
	// In test = new In("test");
	// test.process();
	// }
	//
}
