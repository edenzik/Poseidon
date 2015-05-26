package edu.brandeis.flow.ui.inspector;

import com.vaadin.data.Item;
import com.vaadin.ui.Table;

import edu.brandeis.flow.ui.operator.UIOperator;

//dont need
public class UIOperatorTable extends Table {
	public UIOperatorTable() {
		addContainerProperty("Operator", UIOperator.class, null);
	}

	public void addOperator(UIOperator op) {
		Object newItemId = addItem();
		Item row1 = getItem(newItemId);
		row1.getItemProperty("Operator").setValue(op);
	}
}
