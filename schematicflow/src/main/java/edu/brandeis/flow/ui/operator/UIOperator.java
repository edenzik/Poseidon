package edu.brandeis.flow.ui.operator;

import org.vaadin.visjs.networkDiagram.Node;
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

	protected UIOperator(JSONOperator operator, String imageURI){
		super(operator.hashCode(), operator.toString(), "./VAADIN/themes/valo/img/" + imageURI);
		this.operator = operator;
	}
	
	protected String getType(){
		return operator.toString();
	}

	protected String getName() {
		return "";
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
