package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.TabSheet;

public class InspectorSidebar extends TabSheet {
	public InspectorSidebar(){
		this.setCaption("INSPECTOR");
		this.addTab(new InspectorTabs("IO"), "IO");
		this.addTab(new InspectorTabs("properties"), "Properties");
	}
}
