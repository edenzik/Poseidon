package edu.brandeis.flow.ui.operator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.flow.core.state.State;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Image;
import com.vaadin.ui.Table;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.operator.filter.UIFilterFactory;
import edu.brandeis.flow.ui.operator.in.UIInFactory;
import edu.brandeis.flow.ui.operator.in.twitter.UITwitterInFactory;
import edu.brandeis.flow.ui.operator.join.UIJoinFactory;
import edu.brandeis.flow.ui.operator.map.UIMapFactory;
import edu.brandeis.flow.ui.operator.out.UIOutFactory;

public class StateLayout extends GridLayout{
	private final int numCols = 3;
	private final UIOperatorFactory uiOpFactories[] = new UIOperatorFactory[] {
		new UIFilterFactory(),
		new UIMapFactory(),
		new UIInFactory(),
		new UITwitterInFactory(),
		new UIJoinFactory()
	};

	public StateLayout(){
		setSizeFull();
		setColumns(3);

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
