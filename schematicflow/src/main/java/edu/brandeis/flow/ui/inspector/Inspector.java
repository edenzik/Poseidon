package edu.brandeis.flow.ui.inspector;

import com.vaadin.server.Sizeable;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperator.NetworkCallback;

public abstract class Inspector extends VerticalSplitPanel {
	
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
		
		
		String headName = nc.getOp().getOpName();
		head = new InspectorHeader(headName);
		
		
		tabsheet = new TabSheet();
		
		iotab = new IOTab();
		properties = new PropertyTab();
		connect = new ConnectTab(nc);
		
		
		tabsheet.addTab(properties, "Properties");
		tabsheet.addTab(iotab, "Live View");
		tabsheet.addTab(connect, "Connect");
		tabsheet.setSizeFull();
		head.setHeight("100%");
		addComponent(head);
		addComponent(tabsheet);
		
		this.setSplitPosition(40, Sizeable.UNITS_PERCENTAGE);
		this.setLocked(true);
//		setComponentAlignment(head, Alignment.TOP_CENTER);
//		setComponentAlignment(tabsheet, Alignment.TOP_CENTER);
		
		//this.setExpandRatio(head, 0.2f);
		//this.setExpandRatio(tabsheet, 0.8f);
		

	}


	private void setSplitPosition(String string) {
		// TODO Auto-generated method stub
		
	}
	

}

		
		
		
	
		

