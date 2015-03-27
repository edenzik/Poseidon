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
	private Set<NodeClickListener> currentListeners;
	private Set<NodeClickListener> oldListeners;

	public UIOperatorNetworkDiagram() {
		super(new UIOperatorNetworkOptions());
		nodes = new HashSet<UIOperator>();
		oldListeners = new HashSet<NodeClickListener>();
		currentListeners = new HashSet<NodeClickListener>();
	}

	public void addNode(UIOperator... node) {
		for (UIOperator op : node){
			nodes.add(op);
		}
		super.addNode(node);
	}
	
	
	
	@Override
	public void addNodeClickListener(NodeClickListener nodeClickListener) {
		currentListeners.add(nodeClickListener);
		super.addNodeClickListener(nodeClickListener);
	}

	public void disableClick(){
		for (NodeClickListener ncl : currentListeners){
			oldListeners.add(ncl);
			this.removeNodeClickListeners(ncl);
		}
		currentListeners.clear();
	}
	
	private void deleteCallback(){
		for (Object ncl : getListeners(NodeClickListener.class)){
			removeListener((Listener) ncl);
		}
	}
	
	public void reEnableClick(){
		deleteCallback();
		for (NodeClickListener ncl : oldListeners){
			addNodeClickListener(ncl);
		}
	}
	

	

	
	

}
