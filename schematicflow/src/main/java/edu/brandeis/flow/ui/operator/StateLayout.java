package edu.brandeis.flow.ui.operator;

import java.util.Iterator;

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

public class StateLayout extends VerticalLayout{
	
	public StateLayout(){
		GridLayout iconsLayout = new GridLayout();
//	    iconsLayout.setMargin(true);
	    iconsLayout.setWidth("100%");
	    iconsLayout.setColumns(3);
	    this.addComponent(iconsLayout);
		
	    String iconNames[] = { "arrow-down.png", "arrow-left.png",
	            "arrow-right.png", "arrow-up.png", "calendar.png",
	            "document.png", "document-doc.png", "document-image.png",
	            "document-pdf.png", "document-ppt.png", "document-web.png",
	            "document-xsl.png", "email.png", "globe.png", "reload.png" };

	        for (int i = 0, x = 0, y = 0; i < iconNames.length; i++, x++) {
	          if (x >= iconsLayout.getColumns()) {
	            x = 0;
	            iconsLayout.setRows(++y + 1);
	          }

	          ThemeResource resource = new ThemeResource("../runo/icons/64/"
	              + iconNames[i]);
	          Image icon = new Image(null, resource);

	          DragAndDropWrapper transferable = new DragAndDropWrapper(icon);
	          transferable.setSizeUndefined();
	          transferable.setDragStartMode(DragStartMode.WRAPPER);
	          transferable.setData(resource);

	          iconsLayout.addComponent(transferable, x, y);
	        }
	}

}
