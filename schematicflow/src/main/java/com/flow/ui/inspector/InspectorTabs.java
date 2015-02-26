package com.flow.ui.inspector;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;

public class InspectorTabs extends HorizontalLayout {
	private final Button propertiesButton;
	private final Button IOButton;
	private final Button functionButton;
	private final Button liveButton;
	
	public InspectorTabs(){
		propertiesButton = new Button("Properties");
		IOButton = new Button("I/O");
		functionButton = new Button("Function");
		liveButton = new Button("Live");
		this.addComponent(propertiesButton);
		this.addComponent(IOButton);
		this.addComponent(functionButton);
		this.addComponent(liveButton);
	}
	
	

}
