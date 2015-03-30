package edu.brandeis.flow.ui.inspector;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.Node.NodeClickListener;
import org.vaadin.visjs.networkDiagram.Node.NodeDoubleClickListener;
import org.vaadin.visjs.networkDiagram.event.node.DoubleClickEvent;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.ui.callback.Callback;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperator.NetworkCallback;

final class InspectorIO extends VerticalLayout {
	private final UIOperatorTable table;
	public InspectorIO(NetworkCallback nc){
		this.table = new UIOperatorTable();
		Label label = new Label();
		Button add = new Button("Add output");
		this.addComponent(label);
		this.addComponent(table);
		this.addComponent(add);
		
		setComponentAlignment(label, Alignment.TOP_CENTER);
		setComponentAlignment(table, Alignment.MIDDLE_CENTER);
		setComponentAlignment(add, Alignment.BOTTOM_CENTER);
		table.setHeight(10, Unit.CM);
		table.setWidth(5, Unit.CM);
		this.setSpacing(true);
		
		add.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("Click on a node to connect");
				final Set<NodeClickListener> oldListeners = new HashSet<NodeClickListener>();
				for (UIOperator op : nc.getNetwork().nodes){
					nc.getNetwork().addNodeClickListener(new NodeClickListener(op){

						@Override
						public void onFired(
								org.vaadin.visjs.networkDiagram.event.node.ClickEvent arg0) {
							table.addOperator(op);
							Edge n = new Edge(nc.getOp().getId(), op.getId(), Edge.Style.arrow);
							nc.getNetwork().addEdge(n);
							oldListeners.add(this);
							nc.showInspector();
							
						}
					});
				}
				nc.getNetwork().drawConnections();
				add.removeClickListener(this);
				add.setCaption("Stop adding");
				add.addClickListener(new ClickListener(){

					@Override
					public void buttonClick(ClickEvent event) {
						for (NodeClickListener li : oldListeners){
							nc.getNetwork().removeNodeClickListeners(li);
							add.setCaption("Add output");
							add.removeClickListener(this);
						}
						
					}
					
				});
			
			}
		});
		
	}
	
}
