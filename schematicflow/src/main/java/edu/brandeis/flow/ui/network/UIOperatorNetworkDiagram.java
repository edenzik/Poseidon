package edu.brandeis.flow.ui.network;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.NetworkDiagram;

import edu.brandeis.flow.ui.operator.UIOperator;

public class UIOperatorNetworkDiagram extends NetworkDiagram {
	public final Set<UIOperator> nodes;

	public UIOperatorNetworkDiagram() {
		super(new UIOperatorNetworkOptions());
		UIOperator.ic.network = this;
		setSizeFull();
		nodes = new HashSet<UIOperator>();
	}

	public void addNode(UIOperator... node) {
		for (UIOperator op : node) {
			nodes.add(op);
		}
		super.addNode(node);
	}

}
