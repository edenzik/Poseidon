package edu.brandeis.flow.ui.inspector;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperator.NetworkCallback;

public abstract class Inspector extends VerticalLayout {
	protected final NetworkCallback nc;
	private final IOTab iotab;
	private final PropertyTab properties;
	private final ConnectTab connect;
	private final TabSheet tabsheet;
	private final InspectorHeader head;
	
	
	//private final InspectorIO io;
	public Inspector(NetworkCallback nc){
		this.nc = nc;
		nc.setInspector(this);
		setSizeFull();
		
		String headName = nc.getOp().getOpName();
		head = new InspectorHeader(headName);
		head.setSizeFull();
		tabsheet = new TabSheet();		
		tabsheet.setSizeFull();
		
		iotab = new IOTab();
		properties = new PropertyTab();
		connect = new ConnectTab(nc);
		
		
		tabsheet.addTab(properties, "Properties");
		tabsheet.addTab(iotab, "Live View");
		tabsheet.addTab(connect, "Connect");
		tabsheet.setSizeFull();
		addComponent(head);
		addComponent(tabsheet);
		
		//this.setExpandRatio(head, 0.2f);
		//this.setExpandRatio(tabsheet, 0.8f);
		

	}
	

}

		
		
		
	
		
