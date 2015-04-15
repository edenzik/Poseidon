/**
 * 
 */
package edu.brandeis.flow.core.operator.map;

import java.util.function.Function;

import org.json.JSONException;
import org.json.JSONObject;

import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author Yahui
 *
 */
public final class Map extends JSONOperator {
	String key;
	Function<Double, Double> func;

	/**
	 * Constructor
	 */
	public Map() {
		super();
	}

	/**
	 * Set JSON key
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get JSON key
	 * 
	 * @return String key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set map function
	 * 
	 * @param oper
	 *            user operator in String format
	 * @param num
	 */
	public void setFunc(String oper, Double num) {
		switch (oper) {
		case "times":
			func = val -> val * num;
		case "adds":
			func = val -> val + num;
		case "minus":
			func = val -> val - num;
		case "divides":
			func = val -> val / num;
		default:
			break;
		}
	}

	@Override
	public void run() {
		JSONObject top = read();
		if (top.has(key)) {
			// apply map function
			try {
				top.put(key, func.apply(top.getDouble(key)));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// send the result
			send(top);
		}

	}

}
