package edu.brandeis.flow.ui.inspector.io.table;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;

import com.vaadin.data.Item;
import com.vaadin.ui.Table;

import edu.brandeis.flow.ui.operator.UIOperator;

//dont need
public class LiveViewTable extends Table {
	public LiveViewTable() {
		setSizeFull();
		setColumnHeaderMode(Table.ColumnHeaderMode.HIDDEN);
		setPageLength(0);
		addContainerProperty("Content", JSONObject.class, null);
	}

	public void addItem(JSONObject obj) {
		Object newItemId = addItem();
		Item row1 = getItem(newItemId);
		row1.getItemProperty("Content").setValue(obj);
		this.fireValueChange(false);
	}
}
