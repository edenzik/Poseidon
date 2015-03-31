package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalSplitPanel;



public abstract class Inspector extends VerticalSplitPanel {
	//private UIOperator operator;
	private final TabSheet tabsheet;
	private final InspectorHeader head;

	public Inspector(){
		
		head = new InspectorHeader("To ChangeFilter");
		tabsheet = new InspectorTabs();
		
		head.setHeight("90%");
		head.setMargin(true);
		addComponent(head);
		
		addComponent(tabsheet);
		setSplitPosition(40, Unit.PERCENTAGE);
		
		setLocked(true);

	}








	

}

		
		
		
	
		

