package edu.brandeis.flow.ui.network;

import java.io.IOException;

import org.json.JSONException;
import org.vaadin.visjs.networkDiagram.Node.NodeClickListener;
import org.vaadin.visjs.networkDiagram.event.node.ClickEvent;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.ui.DragAndDropWrapper;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public class UIOperatorNetworkDiagramDragAndDrop extends DragAndDropWrapper {

	private UIOperatorNetworkDiagramDragAndDrop(UIOperatorNetworkDiagram diagram) {
		super(diagram);
		setSizeFull();
		setDropHandler(new DropHandler() {
			public AcceptCriterion getAcceptCriterion() {
				return AcceptAll.get();
			}

			public void drop(DragAndDropEvent event) {
				try {
					UIOperatorFactory opF = (UIOperatorFactory) ((DragAndDropWrapper) event
							.getTransferable().getSourceComponent()).getData();
					UIOperator op = opF.makeUIOperator();

					diagram.addNode(op);
					diagram.addNodeClickListener(new NodeClickListener(op) {

						@Override
						public void onFired(ClickEvent arg0) {
							op.clicked(diagram);

						}

					});
				} catch (JSONException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	public UIOperatorNetworkDiagramDragAndDrop() {
		this(new UIOperatorNetworkDiagram());
	}

}
