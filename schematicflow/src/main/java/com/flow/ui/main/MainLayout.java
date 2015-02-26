package com.flow.ui.main;

import com.flow.ui.states.StateSidebar;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.HorizontalSplitPanel;

public class MainLayout extends HorizontalSplitPanel {
	public MainLayout(){
		StateSidebar sidebar = new StateSidebar();
		this.addComponent(sidebar);
		this.setSizeFull();
		this.setLocked(true);
		this.setSplitPosition(20, Unit.PERCENTAGE);
		
	}
}
