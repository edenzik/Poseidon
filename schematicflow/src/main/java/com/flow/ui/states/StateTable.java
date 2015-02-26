package com.flow.ui.states;

import com.flow.core.state.State;
import com.vaadin.ui.Table;

public class StateTable extends Table{
	
	public StateTable(){
		this.addContainerProperty("State", State.class, null);
	}
}
