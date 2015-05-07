package edu.brandeis.flow.ui.inspector;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.ui.operator.UIOperator;

public class InspectorHeader extends VerticalLayout {
	final TextField name;
	final TextArea desc;

	public InspectorHeader(UIOperator op) {
		name = new TextField("Name");
		setHeight("90%");
		setMargin(true);
		desc = new TextArea("Description");

		name.setValue("Untitled " + op.getOpName());
		Label title = new Label("<h2>" +"Operator Type: " + op.getOpName() + "</h2>");
		name.addValueChangeListener(new TextField.ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				op.setLabel(name.getValue());
				op.getDiagram().updateNode(op);
			}
		});

		title.setHeight("10%");
		title.setContentMode(ContentMode.HTML);

		// title.setSizeUndefined();
		this.setSpacing(false);

		name.setWidth("95%");
		desc.setWidth("95%");
		desc.setHeight("150%");

		this.getMargin().setMargins(true, true, false, true);
		addComponent(title);
		addComponent(name);
		addComponent(desc);
		this.setComponentAlignment(title, Alignment.TOP_CENTER);

	}
}
