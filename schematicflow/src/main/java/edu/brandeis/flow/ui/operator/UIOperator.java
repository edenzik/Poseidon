package edu.brandeis.flow.ui.operator;

import org.json.JSONException;
import org.vaadin.visjs.networkDiagram.Node;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

import edu.brandeis.flow.core.operator.JSONOperator;


public abstract class UIOperator extends Node{
	private final JSONOperator operator;
	private String name;
	private String description;

	protected UIOperator(JSONOperator operator, String name, String description){
		super(operator.hashCode(), name);
		this.name = name;
		this.description = description;
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
