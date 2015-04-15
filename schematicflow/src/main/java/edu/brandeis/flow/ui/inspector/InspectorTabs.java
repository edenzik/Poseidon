package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.TabSheet;

import edu.brandeis.flow.ui.operator.UIOperator;

final class InspectorTabs extends TabSheet {
	final IOTab iotab;
	PropertyTab properties = new PropertyTab();
	ConnectTab connect = new ConnectTab();
	final UIOperator op;

	protected InspectorTabs(UIOperator op) {
		iotab = new IOTab(op);
		this.op = op;
		setSizeFull();

		addTab(properties, "Properties");
		addTab(iotab, "Live View");
		addTab(connect, "Connect");

	}
}
