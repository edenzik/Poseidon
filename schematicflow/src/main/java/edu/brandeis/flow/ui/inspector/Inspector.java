package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalSplitPanel;



public abstract class Inspector extends VerticalSplitPanel {
	//private UIOperator operator;
	public final TabSheet tabs;
	public final InspectorHeader head;
	
	public Inspector(TabSheet tabs, InspectorHeader head){
		this.tabs = tabs;
		this.head = head;
	}

	public Inspector(){
		this(new InspectorTabs(), new InspectorHeader("To ChangeFilter"));
		
		
		addComponent(head);
		
		addComponent(tabs);
		setSplitPosition(40, Unit.PERCENTAGE);
		
		setLocked(true);

	}








	

}

		
		
		
	
		

