package edu.brandeis.ui.storyboard;

import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.Node.NodeBlurListener;
import org.vaadin.visjs.networkDiagram.Node.NodeClickListener;
import org.vaadin.visjs.networkDiagram.event.node.BlurEvent;
import org.vaadin.visjs.networkDiagram.event.node.ClickEvent;
import org.vaadin.visjs.networkDiagram.options.Options;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.Panel;

import edu.brandeis.flow.ui.inspector.InspectorSidebar;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.main.MainLayout.InspectorCallback;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public class StoryBoard extends Panel {
	public StoryBoard(InspectorCallback ic) {
		
		setContent(makeNetwork(ic));
		setSizeFull();	
	}
	
	private Component makeNetwork(InspectorCallback ic){
		NetworkDiagram networkDiagram = new StoryBoardGraph();
		DragAndDropWrapper dndLayout = new DragAndDropWrapper(networkDiagram);

		networkDiagram.setSizeFull();
		dndLayout.setSizeFull();
		dndLayout.setDropHandler(new DropHandler() {
			public AcceptCriterion getAcceptCriterion() {
				return AcceptAll.get();
			}
			public void drop(DragAndDropEvent event) {
				UIOperatorFactory opF = (UIOperatorFactory) ((DragAndDropWrapper)event.getTransferable().getSourceComponent()).getData();
				UIOperator op = opF.makeUIOperator();
				
				networkDiagram.addNode(op);
				networkDiagram.addNodeClickListener(new NodeClickListener(op){

					@Override
					public void onFired(ClickEvent arg0) {
						ic.setInspector(new FilterInspector());
						
					}
					
				});
				
			}
		});
		return dndLayout;
	}
	
	/**
	 * 
	 * 
	 * //this.setContent(createLayout(new AbsoluteLayout()));
		Options options = new Options();
		NetworkDiagram networkDiagram = new NetworkDiagram(options);
		networkDiagram.setSizeFull();
		//addComponent(networkDiagram);
		//crete nodes
		Node node1 = new Node(1,"Node 1");
		Node node2 = new Node(2,"Node 2");
		Node node3 = new Node(3,"Node 3");
		Node node4 = new Node(4,"Node 4");
		Node node5 = new Node(5,"Node 5");
		Node node6 = new Node(6,"Node 6");
		//node6.setImage("../runo/icons/64/arrow-down.png");
		//create edges
		Edge edge1 = new Edge(node1.getId(),node2.getId());
		Edge edge2 = new Edge(node1.getId(),node3.getId());
		Edge edge3 = new Edge(node2.getId(),node5.getId());
		Edge edge4 = new Edge(node2.getId(),node4.getId());
		networkDiagram.addNode(node1);
		networkDiagram.addNode(node2,node3,node4,node5,node6);
		networkDiagram.addEdge(edge1,edge2,edge3,edge4);
		//this.setContent(networkDiagram);
	 */




}
