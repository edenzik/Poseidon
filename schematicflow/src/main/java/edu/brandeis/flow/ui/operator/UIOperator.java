package edu.brandeis.flow.ui.operator;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.Node;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.inspector.Inspector;


public abstract class UIOperator extends Node{
	private final JSONOperator operator;
	private final Inspector inspector;
	private String name;
	private String description;
	private final Set<UIOperator> next;

	protected UIOperator(JSONOperator operator, Inspector inspector){
		super(operator.hashCode(), operator.getName());
		this.inspector = inspector;
		this.operator = operator;
		this.next = new HashSet<UIOperator>();
	}
	
	protected String getType(){
		return operator.getName();
	}

	protected String getName() {
		return inspector.getName();
	}


	public String getDescription() {
		return inspector.getDesc();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return name;
	}

	public void addNext(UIOperator op){
		next.add(op);
		operator.addNext(op.operator);
	}
	
	public void removeNext(UIOperator op){
		next.remove(op);
		operator.removeNext(op.operator);
	}
	
	public Inspector getInspector(){return inspector;}
	
	
	
	
	
	


}
