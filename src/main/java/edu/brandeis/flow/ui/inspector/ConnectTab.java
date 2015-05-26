package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.ui.main.FlowUI;

public class ConnectTab extends VerticalLayout {
	public final UIOperatorTable table;

	public ConnectTab() {
		this.table = new UIOperatorTable();
		Button add = new Button("Add output");
		this.addComponent(table);
		this.addComponent(add);
		
		setComponentAlignment(table, Alignment.MIDDLE_CENTER);
		setComponentAlignment(add, Alignment.BOTTOM_CENTER);
		table.setHeight(8, Unit.CM);
		table.setWidth(100, Unit.PERCENTAGE);
		this.setSpacing(true);
		add.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				((FlowUI) getUI()).layout.storyBoard.setAdd();
			}

		});

	}

}
