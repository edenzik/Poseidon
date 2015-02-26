package com.flow.ui.states;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;

public class AddRemoveStates extends HorizontalSplitPanel {
	private final Button addButton;
	private final Button removeButton;
	
	public AddRemoveStates(){
		addButton = new Button("Add");
		removeButton = new Button("Remove");
	}
	
	public Button getAdd(){
		return addButton;
	}
	
	public Button getRemove(){
		return removeButton;
	}
}
