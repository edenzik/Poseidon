package edu.brandeis.flow.ui.inspector;

import org.json.JSONObject;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.ui.inspector.io.table.LiveViewTable;
import edu.brandeis.flow.ui.operator.UIOperator;

public class IOTab extends VerticalLayout {

	public IOTab(UIOperator op) {
		LiveViewTable lvt = new LiveViewTable();
		this.addComponent(lvt);
		new Thread(new Runnable(){

			@Override
			public void run() {
				while (true){
					try {
						lvt.addItem(op.operator.view().take());
						
						Thread.sleep(100);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}


		}).start();

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
