package edu.brandeis.flow.ui.inspector;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public abstract class Inspector extends Accordion {
	private final InspectorProperties properties;
	private final InspectorIO io;
	public Inspector(){
		setSizeFull();
		properties = new InspectorProperties();
		io = new InspectorIO();
		addTab(properties, "Properties");
		addTab(io, "Properties");
	}
	
	public String getName(){return properties.getName();}
	public String getDesc(){return properties.getDesc();}
}
