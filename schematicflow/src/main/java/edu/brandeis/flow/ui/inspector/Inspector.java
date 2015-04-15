package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.VerticalSplitPanel;

public abstract class Inspector extends VerticalSplitPanel {
	public final InspectorTabs tabs;
	public final InspectorHeader head;

	public Inspector(InspectorTabs tabs, InspectorHeader head) {
		this.tabs = tabs;
		this.head = head;
	}

	public Inspector() {
		this(new InspectorTabs(), new InspectorHeader("To ChangeFilter"));

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

	public String getDescription() {
		return head.desc.getValue();
	}

}
