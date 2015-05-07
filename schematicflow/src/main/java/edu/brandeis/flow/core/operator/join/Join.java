/**
 * 
 */
package edu.brandeis.flow.core.operator.join;

import java.util.Iterator;

import org.json.JSONException;
import edu.brandeis.flow.core.json.JSONObject;

import com.google.common.collect.Iterables;

import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author Yahui
 *
 */
public final class Join extends JSONOperator {
	JSONObject first;
	JSONObject second;
	String key;
	/**
	 * @param name
	 */
	public Join() {
		super();
	}
	
	public void setup(String key){
		this.key = key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void run() {
		while(true) {
			if((first = read()) != null && (second = read())!= null) {
				try {
					if (canJoin()) {
						JSONObject tmp = makeJoin();
						send(makeJoin());
						tmp.changeAnnotation(getCurrTag());
						System.out.println(tmp);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public boolean canJoin() throws JSONException {
		JSONObject tmpFirst = new JSONObject(first.toString().toLowerCase());
		JSONObject tmpSecond = new JSONObject(second.toString().toLowerCase());
		if(!sameTag() &&tmpFirst.has(key.toLowerCase()) && tmpSecond.has(key.toLowerCase())) {
			if (tmpFirst.get(key.toLowerCase()).equals(tmpSecond.get(key.toLowerCase()))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean sameTag() throws JSONException {
		return first.equalAnnotation(second);
	}
	
	public JSONObject makeJoin(){
		Iterator keys_second = second.keys();
		while(keys_second.hasNext()) {
			String tmpKey = keys_second.next().toString();
			if (!first.has(tmpKey)) {
				try {
					first.put(tmpKey, second.get(tmpKey));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return first;
	}
	

	public static void main(String[] args) throws JSONException {
		JSONObject first = new JSONObject("{1: lol, 2:lol, 3:lol, 4:lol, 5:lol}");
		JSONObject second = new JSONObject("{1: lol, 3: lol, 4:lol, 7:lol, 8:lol, 9:lol}");
		JSONObject third = new JSONObject("{1: lol, 2:lol, 5:lol, 4:lol, 3:lol}");
		JSONObject fourth = new JSONObject("{1: lol, 9:lol, 6:lol, 412:lol, 777:lol}");
		first.addAnnotation("1");
		second.addAnnotation("2");
		third.addAnnotation("1");
		fourth.addAnnotation("4");
		Join test = new Join();
		test.setup("1");
		test.receive(first);
		test.receive(second);
		test.receive(third);
		test.receive(fourth);


	}

}
