package com.flow.ui.states;

import java.util.Iterator;

import com.flow.core.state.State;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Table;

public class StateTable extends Table{
	
	public StateTable(){
		this.addContainerProperty("STATE", String.class, null);
		this.addItem(new Object[]{"In"},1);
		this.addItem(new Object[]{"Join"},2);
		this.addItem(new Object[]{"Union"},3);
		this.addItem(new Object[]{"Out"},4);
		this.setDragMode(TableDragMode.ROW);
//		
//		System.out.println("********111*************");
//		
//		for (Iterator<Object> i = (Iterator<Object>) this.getItemIds().iterator(); i.hasNext();) {
//			System.out.println("*********222************");
//			DragAndDropWrapper tableWrap = new DragAndDropWrapper((Component) i.next());
//			tableWrap.setDragStartMode(DragStartMode.COMPONENT);
//			tableWrap.setSizeUndefined();
//			this.addItemAfter(tableWrap, 1);
//			
//		}
	}
}
