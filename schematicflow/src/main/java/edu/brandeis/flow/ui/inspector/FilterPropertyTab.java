package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;

public class FilterPropertyTab extends PropertyTab {
	final TextField key;
	final TextField term;
	
	public FilterPropertyTab() {
//		System.out.println("\n\n\n\n\n\n FOUND \n\n\n\n\n\n");
		key = new TextField("Key");
		term = new TextField("Term");
		Button accept = new Button("Accept");

		key.setWidth("90%");
		term.setWidth("90%");

		addComponent(key);
		addComponent(term);
		addComponent(accept);

		setComponentAlignment(key, Alignment.TOP_CENTER);
		setComponentAlignment(term, Alignment.TOP_CENTER);
		setComponentAlignment(accept, Alignment.BOTTOM_CENTER);
		this.setSpacing(true);
	}

}
