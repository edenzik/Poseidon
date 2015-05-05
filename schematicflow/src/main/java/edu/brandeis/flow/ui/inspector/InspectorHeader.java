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

		Label title = new Label("<h2>" + op.getOpName() + " Operator" + "</h2>");
		name.setValue("Operator" + this.hashCode());
		name.addValueChangeListener(new TextField.ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				System.out.println(event.toString());
				System.out.println(op.getOpName());
				System.out.println(op.getLabel());
				op.setLabel(name.getValue());
				op.getDiagram().updateNode(op);
			}
		});

		title.setHeight("10%");
		title.setContentMode(ContentMode.HTML);

		// title.setSizeUndefined();
		this.setSpacing(false);

		// Image image = new Image(null, new ThemeResource("../images/" +
		// opName+ ".svg"));
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
