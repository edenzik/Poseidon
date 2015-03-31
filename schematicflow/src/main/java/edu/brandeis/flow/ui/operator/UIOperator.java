package edu.brandeis.flow.ui.operator;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.Node;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.callback.Callback;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.main.MainLayout.InspectorCallback;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;


public abstract class UIOperator extends Node{
	public static InspectorCallback ic;
	private final Set<UIOperator> nextOperators;
	public static UIOperator selectedNode;
	public static boolean connectMode = false;
	private final JSONOperator operator;
	private Inspector inspector;
	private String name;
	private String description;

	protected UIOperator(JSONOperator operator, String imageURI){
		super(operator.hashCode(), "Unamed " + operator.toString(), "./VAADIN/themes/valo/img/" + imageURI);
		this.operator = operator;
		this.name = "hello";
		this.description = "some";
		this.nextOperators = new HashSet<UIOperator>();
		this.nextOperators.add(this);
	}



	protected String getType(){
		return operator.toString();
	}

	protected String getName() {
		return name;
	}
	
	protected String getDescription(){
		return description;
	}
	
	protected void setName(String name){
		this.name = name;
		this.setLabel(name);
	}
	
	protected void setDescription(String description){
		this.description = description;
	}
	
	
	public String getOpName() {
		return operator.getName();
	}


	public JSONOperator getJSONOp(){
		return this.operator;
	}
	
	public void addNextOp(JSONOperator next) {
		operator.addNext(next);
	}
	
	public void addNextOp(UIOperator next){
		if (nextOperators.contains(next)) return;
		nextOperators.add(next);
		Edge n = new Edge(this.getId(), next.getId(), Edge.Style.arrow);
		ic.network.addEdge(n);
		inspector.getTable().addOperator(next);
		//addNextOp(next.operator);
	}
	
	public void clicked(UIOperatorNetworkDiagram nd){
		if (inspector==null) inspector = makeInspector();
		if (connectMode){
			selectedNode.addNextOp(this);
			connectMode = false;
			return;
		} else{
			selectedNode = this;
			ic.setInspector(inspector);
		}
	}
	
	protected abstract Inspector makeInspector();
	
	public class NetworkCallback{
		final InspectorCallback ic;
		final UIOperator op;
		final UIOperatorNetworkDiagram nd;
		public Inspector inspector;
		
		NetworkCallback(InspectorCallback ic, UIOperatorNetworkDiagram nd, UIOperator op){
			this.ic = ic;
			this.nd = nd;
			this.op = op;
		}
		
		public void setInspector(Inspector inspector){this.inspector = inspector;}
		
		public void showInspector(){ic.setInspector(inspector);}
		
		public UIOperatorNetworkDiagram getNetwork(){return nd;}

		public UIOperator getOp() {
			return op;
		}
		
		
		
	}
	
	
	
	@Override
	public String toString() {
		return getName();
	}


	public Inspector getInspector(){
		return inspector;
	}



	
	
	
	
	


}
