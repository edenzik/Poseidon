package edu.brandeis.flow.ui.network;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.Node.NodeClickListener;
import org.vaadin.visjs.networkDiagram.event.node.ClickEvent;
import org.vaadin.visjs.networkDiagram.options.Options;

import com.vaadin.ui.Component.Listener;

import edu.brandeis.flow.ui.callback.Callback;
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
		for (UIOperator op : node){
			nodes.add(op);
		}
		super.addNode(node);
	}
	
	
	

	

	

	
	

}
