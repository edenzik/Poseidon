package edu.brandeis.flow.ui.network;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;

import edu.brandeis.flow.ui.operator.UIOperator;

public class UIOperatorNetworkDiagram extends NetworkDiagram {
	private static final long serialVersionUID = 1L;
	public final Set<UIOperator> nodes;

	public UIOperatorNetworkDiagram() {
		super(new UIOperatorNetworkOptions());
		setSizeFull();
		nodes = new HashSet<UIOperator>();
	}

	public void addNode(UIOperator node) {
		super.addNode(node);
		nodes.add(node);
	}

	public void removeNode(UIOperator node) {
		// TODO Auto-generated method stub
		super.removeNode(node);
		nodes.remove(node);
	}

	
	
	
	


}
