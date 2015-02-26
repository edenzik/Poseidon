package com.flow.ui.states;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

public class StateSidebar extends VerticalSplitPanel {
	public StateSidebar(){
		StateTable st = new StateTable();
		st.setSizeFull();
		this.setSplitPosition(95, Unit.PERCENTAGE);
		this.setLocked(true);
		this.setHeight(100, Unit.PERCENTAGE);
		AddRemoveStates ads = new AddRemoveStates();
		this.addComponent(st);
		this.addComponent(ads);
	}
}
