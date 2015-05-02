package edu.brandeis.flow.ui.inspector.io.table;

import org.json.JSONObject;

import com.vaadin.data.Item;
import com.vaadin.ui.Table;

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
