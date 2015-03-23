package edu.brandeis.flow.ui.operator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.flow.core.state.State;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Image;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.core.operator.JSONOperator;

public class StateLayout extends GridLayout{

	public StateLayout(){
		setSizeFull();
		setColumns(3);

		String iconNames[] = { "arrow-down.png", "arrow-left.png",
				"arrow-right.png", "arrow-up.png", "calendar.png",
				"document.png", "document-doc.png", "document-image.png",
				"document-pdf.png", "document-ppt.png", "document-web.png",
				"document-xsl.png", "email.png", "globe.png", "reload.png" };
		Set<UIOperatorFactory> operatorFactories = new HashSet<UIOperatorFactory>();
		operatorFactories.add(new UIFilterFactory());
		operatorFactories.add(new UIFilterFactory());
		operatorFactories.add(new UIFilterFactory());
		//operatorFactories.add(new UIINFactory());
		for (UIOperatorFactory uiOp : operatorFactories){
			DragAndDropWrapper transferable = new DragAndDropWrapper(uiOp);
			transferable.setSizeUndefined();
			transferable.setDragStartMode(DragStartMode.WRAPPER);
			transferable.setData(uiOp);
			addComponent(transferable);
		}
		
	}

}
