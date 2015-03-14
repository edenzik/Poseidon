package com.flow.ui.workspace;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.HorizontalSplitPanel;

import edu.brandeis.flow.ui.inspector.InspectorSidebar;

public class MainWorkspace extends HorizontalSplitPanel {
	public MainWorkspace(){
		this.setSizeFull();
		this.setSplitPosition(80, Unit.PERCENTAGE);
		this.addComponent(new WorkspaceBoard());
		this.addComponent(new InspectorSidebar());
	}
}
