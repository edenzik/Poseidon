package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.TabSheet;

import edu.brandeis.flow.ui.operator.UIOperator;

public final class InspectorTabs extends TabSheet {
	final IOTab iotab;
	public PropertyTab properties;
	public ConnectTab connect = new ConnectTab();
	final UIOperator op;

	protected InspectorTabs(UIOperator op) {
		iotab = new IOTab(op);
		this.op = op;
		setSizeFull();
	} 
	public void setProperties(PropertyTab properties) {
		this.properties = properties;
		
	}
	
	public void setTabs() {
		addTab(properties, "Properties");
		addTab(iotab, "Live View");
		addTab(connect, "Connect");

	}
}
