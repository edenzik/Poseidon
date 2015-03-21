package edu.brandeis.flow.ui.inspector;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperator.NetworkCallback;

public abstract class Inspector extends Accordion {
	protected final NetworkCallback nc;
	private final InspectorProperties properties;
	private final InspectorIO io;
	//private final InspectorIO io;
	public Inspector(NetworkCallback nc){
		this.nc = nc;
		nc.setInspector(this);
		setSizeFull();
		properties = new InspectorProperties();
		//io = new InspectorIO();
		addTab(properties, "Properties");
		
		io = new InspectorIO(nc);
		addTab(io, "IO");
	}
	
//	public String getName(){return properties.getName();}
	//public String getDesc(){return properties.getDesc();}
}
