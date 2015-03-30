package edu.brandeis.flow.ui.sidebar;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Image;
import com.vaadin.ui.Table;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.state.State;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;
import edu.brandeis.flow.ui.operator.filter.UIFilterFactory;
import edu.brandeis.flow.ui.operator.in.UIInFactory;
import edu.brandeis.flow.ui.operator.in.twitter.UITwitterInFactory;
import edu.brandeis.flow.ui.operator.join.UIJoinFactory;
import edu.brandeis.flow.ui.operator.map.UIMapFactory;
import edu.brandeis.flow.ui.operator.out.UIOutFactory;

public class OperatorFactoryLayout extends GridLayout{
	private final int numCols = 2;
	private final UIOperatorFactory uiOpFactories[] = new UIOperatorFactory[] {
		new UIFilterFactory(),
		new UIInFactory(),
		new UITwitterInFactory(),
		new UIMapFactory(),
		new UIJoinFactory()
	};

	public OperatorFactoryLayout(){
		setSizeFull();
		setColumns(numCols);
		this.setMargin(true);
		for (UIOperatorFactory uiOp : uiOpFactories){
			uiOp.setWidth(this.getWidth()/3, this.getWidthUnits());
			uiOp.setHeight(this.getHeight()/3, this.getHeightUnits());
			DragAndDropWrapper transferable = new DragAndDropWrapper(uiOp);
			transferable.setSizeUndefined();
			transferable.setDragStartMode(DragStartMode.WRAPPER);
			transferable.setData(uiOp);
			addComponent(transferable);
		}
		
		
	}

}
