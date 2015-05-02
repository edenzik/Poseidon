package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.VerticalSplitPanel;

import edu.brandeis.flow.ui.operator.UIOperator;

public abstract class Inspector extends VerticalSplitPanel {
	public InspectorTabs tabs;
	public final InspectorHeader head;
	public UIOperator op = null;


	public Inspector(UIOperator op) {
		this.op = op;
		this.tabs = new InspectorTabs(op);
		this.head = new InspectorHeader(op.getOpName());

		addComponent(head);

		addComponent(tabs);
		setSplitPosition(40, Unit.PERCENTAGE);

		setLocked(true);

	}

	public UIOperatorTable getTable() {
		return tabs.connect.table;
	}

	public String getName() {
		return head.name.getValue();
	}

	@Override
	public String getDescription() {
		return head.desc.getValue();
	}

}
