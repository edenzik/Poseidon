package edu.brandeis.ui.storyboard;

import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.ui.Panel;

import edu.brandeis.flow.ui.main.FlowUI;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagramDragAndDrop;
import edu.brandeis.flow.ui.operator.UIOperator;

public class StoryBoard extends Panel {
	private Mode mode;
	private UIOperator selectedNode;
	public final UIOperatorNetworkDiagram network;
	public StoryBoard() {
		mode = Mode.Select;
		network = new UIOperatorNetworkDiagram();
		setContent(new UIOperatorNetworkDiagramDragAndDrop(network));
		setSizeFull();

	}
	
	public UIOperator getSelectedOperator(){
		return selectedNode;
		
	}
	
	public void setSelectedOperator(UIOperator op){
		selectedNode = op;
	}
	
	public Mode getMode(){
		return mode;
	}
	
	public void setSelect(){
		mode = Mode.Select;
	}
	
	public void setAdd(){
		mode = Mode.Add;
	}
}
