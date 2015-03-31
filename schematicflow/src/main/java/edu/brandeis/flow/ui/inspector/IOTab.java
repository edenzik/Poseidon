package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class IOTab extends VerticalLayout {

	public IOTab() {

		Panel in = new Panel("In Stream");
		in.setContent(new Label("Here prints the input stream"));
		in.setHeight(10, Unit.CM);
		// in.setSizeFull();
		// //test
		// Label test = new Label("xx");
		// test.addListener(listener);

		Panel out = new Panel("Out Stream");
		out.setContent(new Label("Here prints the output stream"));
		// out.setHeight(8, Unit.CM);
		// out.setSizeFull();

		this.addComponent(in);
		// this.addComponent(out);

	}
	// private final Button propertiesButton;
	// private final Button IOButton;
	// private final Button functionButton;
	// private final Button liveButton;
	//
	// public InspectorTabs(){
	// propertiesButton = new Button("Properties");
	// IOButton = new Button("I/O");
	// functionButton = new Button("Function");
	// liveButton = new Button("Live");
	// this.addComponent(propertiesButton);
	// this.addComponent(IOButton);
	// this.addComponent(functionButton);
	// this.addComponent(liveButton);
	// }

}
