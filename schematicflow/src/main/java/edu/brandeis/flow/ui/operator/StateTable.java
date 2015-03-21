package edu.brandeis.flow.ui.operator;

import java.util.Iterator;

import com.flow.core.state.State;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Table;

import edu.brandeis.flow.core.operator.JSONOperator;

public class StateTable extends Table{
	
	public StateTable(){
		this.addContainerProperty("Operators", UIOperatorFactory.class, null);
		this.addItem(new UIOperatorFactory[]{new UIFilterFactory()}, 1);
		this.addItem(new UIOperatorFactory[]{new UIFilterFactory()}, 2);
		this.addItem(new UIOperatorFactory[]{new UIFilterFactory()}, 3);
		this.setSelectable(true);
		this.setDragMode(TableDragMode.ROW);

	}
}
