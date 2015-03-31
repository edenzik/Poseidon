package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

final class InspectorTabs extends TabSheet {
	protected InspectorTabs(){
		setSizeFull();
		
		Component iotab = new IOTab();
		Component properties = new PropertyTab();
		Component connect = new ConnectTab();
		
		addTab(properties, "Properties");
		addTab(iotab, "Live View");
		addTab(connect, "Connect");
		
	}
}
