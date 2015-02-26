package com.flow.ui.states;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;

public class AddRemoveStates extends HorizontalSplitPanel {
	private final Button addButton;
	private final Button removeButton;
	
	public AddRemoveStates(){
		addButton = new Button("Add");
		addButton.setSizeFull();
		removeButton = new Button("Remove");
		removeButton.setSizeFull();
		this.setLocked(true);
		this.setSplitPosition(50, Unit.PERCENTAGE);
		this.addComponent(addButton);
		this.addComponent(removeButton);
	}
	
	public Button getAdd(){
		return addButton;
	}
	
	public Button getRemove(){
		return removeButton;
	}
}
