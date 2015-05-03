package edu.brandeis.flow.ui.inspector;


import org.json.JSONObject;
import org.vaadin.addons.d3Gauge.Gauge;

import com.github.wolfie.refresher.Refresher;
import com.github.wolfie.refresher.Refresher.RefreshListener;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Component.Event;

import edu.brandeis.flow.ui.inspector.io.table.LiveViewTable;
import edu.brandeis.flow.ui.operator.UIOperator;

public class IOTab extends VerticalLayout {

	public IOTab(UIOperator op) {
		
		Gauge gauge = new Gauge("Incoming",76,200);

		
        Refresher refresher = new Refresher();
        refresher.setRefreshInterval(4000);
        int s = 0;
        refresher.addListener(new Refresher.RefreshListener() {
            @Override
            public void refresh(Refresher refresher) {
                gauge.setValue((int)System.currentTimeMillis()/1000);
            }
        });

        addExtension(refresher);

		this.addComponent(gauge);
		
		/**
		LiveViewTable lvt = new LiveViewTable();
		this.addComponent(lvt);
		new Thread(new Runnable(){

			@Override
			public void run() {
				while (true){
					try {
						lvt.addItem(op.operator.view().take());
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}


		}).start();

		// this.addComponent(out);**/

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
