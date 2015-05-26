package edu.brandeis.flow.ui.inspector;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

class InspectorProperties extends VerticalLayout {
	final TextField name;
	final TextArea desc;

	public InspectorProperties() {
		name = new TextField("Name");
		Label title = new Label("<h2>Filter</h2>");
		title.setContentMode(ContentMode.HTML);
		title.setSizeUndefined();
		// name.setSizeFull();
		desc = new TextArea("Description");
		// desc.setSizeFull();
		Image image = new Image(null, new ThemeResource(
				"../runo/icons/64/arrow-down.png"));
		image.setSizeFull();
		addComponent(title);
		addComponent(image);
		addComponent(name);
		addComponent(desc);
		setComponentAlignment(title, Alignment.TOP_CENTER);
		setComponentAlignment(image, Alignment.TOP_CENTER);
		setComponentAlignment(name, Alignment.MIDDLE_CENTER);
		setComponentAlignment(desc, Alignment.BOTTOM_CENTER);
	}

	// protected String getName(){return name.getValue();}
	// protected String getDesc(){return desc.getValue();}
}
