package com.flow.ui.workspace;

import com.flow.ui.inspector.InspectorSidebar;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.HorizontalSplitPanel;

public class MainWorkspace extends HorizontalSplitPanel {
	public MainWorkspace(){
		this.setSizeFull();
		this.setSplitPosition(80, Unit.PERCENTAGE);
		this.addComponent(new WorkspaceBoard());
		this.addComponent(new InspectorSidebar());
	}
}
