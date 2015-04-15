package edu.brandeis.flow.ui.operator;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.Node;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.main.FlowUI;
import edu.brandeis.flow.ui.main.MainLayout.InspectorCallback;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.ui.storyboard.StoryBoard;

public abstract class UIOperator extends Node {
	public static InspectorCallback ic;
	private final Set<UIOperator> nextOperators;
	public static UIOperator selectedNode;
	public static boolean connectMode = false;
	private final JSONOperator operator;
	private transient Inspector inspector;
	private String name;
	private String description;

	protected UIOperator(JSONOperator operator, String imageURI, Inspector inspector) {
		super(operator.hashCode(), "Unamed " + operator.toString(),
				"./VAADIN/themes/valo/img/" + imageURI);
		this.operator = operator;
		this.nextOperators = new HashSet<UIOperator>();
		this.inspector = inspector;
	}

	protected String getType() {
		return operator.toString();
	}

	protected String getName() {
		return inspector.getName();
	}

	protected String getDescription() {
		return inspector.getDescription();
	}

	protected void setName(String name) {
		this.name = name;
		this.setLabel(name);
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	public String getOpName() {
		return operator.toString();
	}

	public JSONOperator getJSONOp() {
		return this.operator;
	}

	public void addNextOp(JSONOperator next) {
		operator.addNext(next);
	}

	public Edge addNextOp(UIOperator next) {
		if (next==this) return null;
		if (nextOperators.contains(next)) return null;
		nextOperators.add(next);
		inspector.getTable().addOperator(next);
		addNextOp(next.operator);
		return new Edge(this.getId(), next.getId(), Edge.Style.arrow);
	}

	public void clicked(FlowUI ui) {
		switch (ui.layout.storyBoard.getMode()){
			case Add:
				StoryBoard sb = ui.layout.storyBoard;
				sb.network.addEdge(sb.getSelectedOperator().addNextOp(this));
				ui.layout.storyBoard.setSelect();
			case Select:
				ui.layout.setInspector(inspector);
		}
	}
	
	public void removeInspector(FlowUI ui) {
		ui.removeInspector();
	}

	protected abstract Inspector makeInspector();

	public class NetworkCallback {
		final InspectorCallback ic;
		final UIOperator op;
		final UIOperatorNetworkDiagram nd;
		public Inspector inspector;

		NetworkCallback(InspectorCallback ic, UIOperatorNetworkDiagram nd,
				UIOperator op) {
			this.ic = ic;
			this.nd = nd;
			this.op = op;
		}

		public void setInspector(Inspector inspector) {
			this.inspector = inspector;
		}

		public void showInspector() {
			ic.setInspector(inspector);
		}

		public UIOperatorNetworkDiagram getNetwork() {
			return nd;
		}

		public UIOperator getOp() {
			return op;
		}

	}

	@Override
	public String toString() {
		return getName();
	}

	public Inspector getInspector() {
		return inspector;
	}

}
