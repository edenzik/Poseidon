package edu.brandeis.flow.ui.operator;

import org.json.JSONException;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

import edu.brandeis.flow.core.operator.JSONOperator;


public abstract class UIOperator extends Label{
	private final JSONOperator operator;
	private String name;
	private String description;

	protected UIOperator(JSONOperator operator, String name, String description){
		super(name);
		this.name = name;
		this.description = description;
//  new ClassResource("https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fphotos%2F34700000%2FRoses-flowers-34758621-1920-1052.jpg&f=1"));
		this.operator = operator;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public abstract UIOperator copy();
	
	
	


}
