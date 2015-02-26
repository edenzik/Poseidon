package com.flow.ui.inspector;

import com.flow.ui.states.AddRemoveStates;
import com.flow.ui.states.StateTable;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.VerticalSplitPanel;

public class InspectorSidebar extends VerticalSplitPanel {
	public InspectorSidebar(){
		PropertiesInspectorPanel st = new PropertiesInspectorPanel();
		InspectorTabs it = new InspectorTabs();
		st.setSizeFull();
		this.setSplitPosition(95, Unit.PERCENTAGE);
		this.setLocked(true);
		this.setHeight(100, Unit.PERCENTAGE);
		this.addComponent(st);
		this.addComponent(it);
	}
}
