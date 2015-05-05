package edu.brandeis.flow.ui.sidebar;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalSplitPanel;

import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public class OperatorFactoryDescriptionSidebar extends VerticalSplitPanel {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public OperatorFactoryDescriptionSidebar() {
		Label label = new Label("");
		this.setLocked(true);
		final OperatorFactoryLayout sl = new OperatorFactoryLayout();
		sl.setSizeFull();

		this.setFirstComponent(sl);
		// description
		final Panel desc = new Panel("DESCRIPTION");
		desc.setContent(label);
		desc.setHeight("100%");

		this.setSecondComponent(desc);
		this.setSplitPosition(70, Unit.PERCENTAGE);

		sl.addListener(new LayoutClickListener() {

			@Override
			public void layoutClick(LayoutClickEvent event) {
				UIOperatorFactory child = (UIOperatorFactory) event
						.getClickedComponent();
				try {
					switch (child.getType()) {
					case "In":
						label.setValue("The In operator forwards an incoming stream to other operators");
						break;

					case "Out":
						label.setValue("The out operator is the endpoint which specifies where to store the data");
						break;

					case "Twitter":
						label.setValue("This is the Twitter In node");
						break;

					case "Map":
						label.setValue("The Map operator applies a function on the stream");
						break;

					case "Filter":
						label.setValue("The Filter operator applies a predicate on the stream");
						break;

					case "Join":
						label.setValue("The Join operator joins multiple streams into one based on a predicate.");
						break;

					}
				} catch (NullPointerException npe) {
					System.out.println("Null");
				}
			}

		});

	}

}