package edu.brandeis.ui.storyboard;

import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node.NodeClickListener;
import org.vaadin.visjs.networkDiagram.event.node.ClickEvent;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.Panel;

import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.main.MainLayout.InspectorCallback;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public class StoryBoard extends Panel {
	public StoryBoard(InspectorCallback ic) {
		
		setContent(makeNetwork(ic));
		setSizeFull();	
	}
	
	private Component makeNetwork(InspectorCallback ic){
		UIOperatorNetworkDiagram networkDiagram = new UIOperatorNetworkDiagram();
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
						op.clicked(ic, networkDiagram);
						
					}
					
				});
				
			}
		});
		return dndLayout;
	}
	




}
