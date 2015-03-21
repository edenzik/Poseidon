package edu.brandeis.flow.ui.operator;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.Node;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;


public abstract class UIOperator extends Node{
	private final JSONOperator operator;
	private Inspector inspector;

	protected UIOperator(JSONOperator operator){
		super(operator.hashCode(), operator.toString());
		this.operator = operator;
	}
	
	public void doStuff(){
		if (inspector == null) inspector = new FilterInspector();
	}
	
	protected String getType(){
		return operator.toString();
	}

	protected String getName() {
		return "";
		//return inspector.getName();
	}


	public String getDescription() {
		return "";
		//return inspector.getDesc();
	}
	
	
	
	@Override
	public String toString() {
		return "";
	}


	public Inspector getInspector(){
		return inspector;
	}



	
	
	
	
	


}
