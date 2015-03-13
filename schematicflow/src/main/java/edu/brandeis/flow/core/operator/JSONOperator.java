package edu.brandeis.flow.core.operator;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.json.JSONObject;

import com.vaadin.ui.Image;

abstract class JSONOperator implements Operator<JSONObject> {
	
	private final Queue<JSONObject> buffer;
	private Set<Operator<JSONObject>> next;
	private String name;
	private String description;
	private Image img;
	
	private JSONOperator(){
		this.buffer = new ConcurrentLinkedQueue<JSONObject>();
	}

	public void recieve(JSONObject obj) {
		buffer.add(obj);
	}

	public void send(JSONObject obj) {
		for (Operator<JSONObject> op : next)op.recieve(obj);
	}

	public abstract void process();

	public void setName(String name) {
		this.name = name;
		
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage(Image img) {
		this.img = img;
		
	}

	public void addNext(Operator<JSONObject> op) {
		next.add(op);
	}
	
}
