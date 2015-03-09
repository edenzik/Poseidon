package com.flow.ui.inspector;

import com.flow.ui.states.AddRemoveStates;
import com.flow.ui.states.StateTable;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalSplitPanel;

public class InspectorSidebar extends TabSheet {
	public InspectorSidebar(){
		this.setCaption("INSPECTOR");
		this.addTab(new InspectorTabs("IO"), "IO");
		this.addTab(new InspectorTabs("properties"), "Properties");
	}
}
