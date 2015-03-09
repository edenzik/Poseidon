package com.flow.ui.main;

import com.flow.ui.inspector.InspectorSidebar;
import com.flow.ui.states.StateSidebar;
import com.flow.ui.storyboard.StoryBoard;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;

public class MainLayout extends HorizontalSplitPanel {
	public MainLayout(){
		
		//add State
		StateSidebar sidebar = new StateSidebar();
		this.setFirstComponent(sidebar);
		this.setSplitPosition(15, Unit.PERCENTAGE);
		this.setLocked(true);
		
		//add another split panel
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		hsplit.setFirstComponent(new StoryBoard());
		hsplit.setSplitPosition(83, Unit.PERCENTAGE);
		hsplit.setLocked(true);
		hsplit.setSecondComponent(new InspectorSidebar());
		
		this.setSecondComponent(hsplit);
	
	}
}
