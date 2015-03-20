package edu.brandeis.ui.storyboard;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

import org.json.JSONException;
import org.json.JSONObject;
import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.options.Options;

import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.Transferable;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.DropTarget;
import com.vaadin.event.dd.TargetDetails;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.ClientMethodInvocation;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Extension;
import com.vaadin.server.Resource;
import com.vaadin.server.ServerRpcManager;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.shared.ui.dd.VerticalDropLocation;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.AbsoluteLayout.ComponentPosition;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.DragAndDropWrapper.WrapperTransferable;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.TableTransferable;
import com.vaadin.ui.Tree.TreeTargetDetails;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

import edu.brandeis.flow.ui.operator.UIOperator;

public class StoryBoard extends Panel {
	public StoryBoard() {
		//this.setContent(createLayout(new AbsoluteLayout()));
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
		//create edges
		Edge edge1 = new Edge(node1.getId(),node2.getId());
		Edge edge2 = new Edge(node1.getId(),node3.getId());
		Edge edge3 = new Edge(node2.getId(),node5.getId());
		Edge edge4 = new Edge(node2.getId(),node4.getId());
		networkDiagram.addNode(node1);
		networkDiagram.addNode(node2,node3,node4,node5,node6);
		networkDiagram.addEdge(edge1,edge2,edge3,edge4);
		this.setContent(networkDiagram);
		setSizeFull();
		
	}

	private Component createLayout(final AbsoluteLayout layout) {
		DragAndDropWrapper dndLayout = new DragAndDropWrapper(layout);
		
		dndLayout.setSizeFull();
		dndLayout.setDropHandler(new DropHandler() {
			public AcceptCriterion getAcceptCriterion() {
				return AcceptAll.get();
			}

			public void drop(DragAndDropEvent event) {
				TableTransferable t = (TableTransferable) event.getTransferable();
				UIOperator op = (UIOperator) t.getSourceContainer().getContainerProperty(t.getItemId(), "Operators").getValue();
				//t.getSourceComponent().removeAllItems();
				UIOperator f = op.copy();
				layout.addComponent(f);
				ComponentPosition k = layout.new ComponentPosition();
				k.setBottom((float) 5.0, Sizeable.Unit.CM);
				layout.new ComponentPosition();
				//Object k = this.new ComponentPosition();
				layout.setPosition(f, k);
			}
		});
		return dndLayout;
	}


}
