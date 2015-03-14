package edu.brandeis.flow.ui.operator;

import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
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
		
		this.setLocked(true);
		final StateTable st = new StateTable();
		st.setSizeFull();
				
		this.addComponent(st);
		//description
		final Panel desc = new Panel("DESCRIPTION");
		st.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			public void itemClick(ItemClickEvent event) {
				desc.setContent(new Label(((UIOperator) event.getItem().getItemProperty("Operators").getValue()).getDescription()));
			}
		});
		desc.setContent(new Label("Here is reserved for operators' descriptions"));
		desc.setHeight(100, Unit.PERCENTAGE);
		this.addComponent(desc);
	}
}
