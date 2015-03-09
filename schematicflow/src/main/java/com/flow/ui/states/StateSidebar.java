package com.flow.ui.states;

import com.vaadin.data.Item;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

public class StateSidebar extends VerticalSplitPanel {
	public StateSidebar(){
		
		this.setSplitPosition(70, Unit.PERCENTAGE);
		this.setLocked(true);
		this.setHeight(100, Unit.PERCENTAGE);
		//state table
		StateTable st = new StateTable();
		st.setSizeFull();
		//setup operators:Join, Union, In and Out
				
		this.addComponent(st);
		//description
		Panel desc = new Panel("DESCRIPTION");
		desc.setContent(new Label("Here is reserved for operators' descriptions"));
		desc.setHeight(100, Unit.PERCENTAGE);
		this.addComponent(desc);
	}
}
