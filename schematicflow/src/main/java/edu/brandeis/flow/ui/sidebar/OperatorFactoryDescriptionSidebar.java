package edu.brandeis.flow.ui.sidebar;

import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public class OperatorFactoryDescriptionSidebar extends VerticalSplitPanel {
	@SuppressWarnings("deprecation")
	public OperatorFactoryDescriptionSidebar(){
		Label label = new Label ("Description Here");
		this.setLocked(true);
		final OperatorFactoryLayout sl = new OperatorFactoryLayout();
		sl.setSizeFull();
				
		this.addComponent(sl);
		//description
		final Panel desc = new Panel("DESCRIPTION");
		desc.setContent(label);
		desc.setHeight(100, Unit.PERCENTAGE);
		this.addComponent(desc);
		
		sl.addListener(new LayoutClickListener() {

			@Override
			public void layoutClick(LayoutClickEvent event) {
				UIOperatorFactory child = (UIOperatorFactory) event.getClickedComponent();
				
				switch (child.getType()) {
					case "In": label.setValue("The In operator forwards an incoming stream to other operators");
					break;
					
					case "Out": label.setValue("The out operator is the endpoint which specifies where to store the data");
					break;
					
					case "Twitter": label.setValue("This is the Twitter In node");
					break;
					
					case "Map": label.setValue("The Map operator applies a function on the stream");
					break;
					
					case "Filter": label.setValue("The Filter operator applies a predicate on the stream");
					break;
					
					case "Join": label.setValue("The Join operator joins multiple streams into one based on a predicate.");
					break;
					
				}
			}
			
		});


	}
	
}