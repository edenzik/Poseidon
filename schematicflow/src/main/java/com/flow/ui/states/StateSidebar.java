package com.flow.ui.states;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class StateSidebar extends VerticalLayout {
	public StateSidebar(){
		StateTable st = new StateTable();
		st.setSizeFull();
		
		AddRemoveStates ads = new AddRemoveStates();
		this.addComponent(st);
		this.addComponent(ads);
	}
}
