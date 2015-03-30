package edu.brandeis.flow.ui.operator;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.Node.NodeClickListener;
import org.vaadin.visjs.networkDiagram.event.node.ClickEvent;

import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.HorizontalLayout;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.callback.Callback;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.main.MainLayout.InspectorCallback;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;


public abstract class UIOperator extends Node{
	private final JSONOperator operator;
	private static boolean toggle = true;
	private static Callback cb = null;
	private Inspector inspector;

	protected UIOperator(JSONOperator operator){
		super(operator.hashCode(), operator.toString());
		this.operator = operator;
	}
	
	protected String getType(){
		return operator.toString();
	}

	protected String getName() {
		return "";
		//return inspector.getName();
	}
	
	public String getOpName() {
		return operator.getName();
	}


	public String getDescription() {
		return "";
		//return inspector.getDesc();
	}
	
	public JSONOperator getJSONOp(){
		return this.operator;
	}
	
	public void addNextOp(JSONOperator next) {
		operator.addNext(next);
	}
	
	public void clicked(InspectorCallback ic, UIOperatorNetworkDiagram nd){
		if (inspector == null) inspector = new FilterInspector(new NetworkCallback(ic, nd, this));
		ic.setInspector(inspector);
		
	}
	
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
		return "";
	}


	public Inspector getInspector(){
		return inspector;
	}



	
	
	
	
	


}
