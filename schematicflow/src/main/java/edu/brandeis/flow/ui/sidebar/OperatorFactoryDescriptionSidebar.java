package edu.brandeis.flow.ui.sidebar;

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

public class OperatorFactoryDescriptionSidebar extends VerticalSplitPanel {
	public OperatorFactoryDescriptionSidebar(){
		
		this.setLocked(true);
		final OperatorFactoryLayout sl = new OperatorFactoryLayout();
		sl.setSizeFull();
				
		this.addComponent(sl);
		//description
		final Panel desc = new Panel("DESCRIPTION");
//		sl.addItemClickListener(new ItemClickEvent.ItemClickListener() {
//			public void itemClick(ItemClickEvent event) {
//				desc.setContent(new Label(((UIOperator) event.getItem().getItemProperty("Operators").getValue()).getDescription()));
//			}
//		});
		desc.setContent(new Label("Here is reserved for operators' descriptions"));
		desc.setHeight(100, Unit.PERCENTAGE);
		this.addComponent(desc);
	}
}
