package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

final class InspectorTabs extends TabSheet {
	IOTab iotab = new IOTab();
	PropertyTab properties = new PropertyTab();
	ConnectTab connect = new ConnectTab();
	protected InspectorTabs(){
		setSizeFull();
		
		addTab(properties, "Properties");
		addTab(iotab, "Live View");
		addTab(connect, "Connect");
		
	}
}
