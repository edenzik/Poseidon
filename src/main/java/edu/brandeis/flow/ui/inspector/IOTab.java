package edu.brandeis.flow.ui.inspector;

import org.json.JSONObject;
import org.vaadin.addons.d3Gauge.Gauge;
import org.vaadin.addons.d3Gauge.GaugeConfig;
import org.vaadin.addons.d3Gauge.GaugeStyle;
import org.vaadin.teemu.jsoncontainer.JsonContainer;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;

import edu.brandeis.flow.ui.inspector.io.table.LiveViewTable;
import edu.brandeis.flow.ui.operator.UIOperator;

public class IOTab extends VerticalLayout {
	Window preview = null;
	public IOTab(UIOperator op) {
		
		
		
		GaugeConfig config = new GaugeConfig(); 
		//config.setStyle(GaugeStyle.STYLE_DARK.toString());
		config.setMax(1);
		Button sample = new Button("Sample Data");
		sample.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				JSONObject top = op.operator.preview();
				if (top==null) {
					Notification.show("Currently Empty", Notification.TYPE_TRAY_NOTIFICATION);
					return;
				}
				addPreviewWindow(top);

				
				
			}
		});
		Gauge initialGauge = new Gauge("Rate",0,300, config);
		UI ui = UI.getCurrent();
		IOTab dis = this;
		Runnable s = new Runnable() {
		    @Override
		    public void run() {
		    	int val = 0;
		    	Gauge gauge = initialGauge;
		    	while (op.operator.thread.isAlive()){
		    		val = op.operator.getRate();
		    		if (gauge.getValue()!=val){
		    			gauge.setValue(val);
		    			if (val>config.getMax()){
		    				try {
		    				config.setMax(config.getMax()*10);
		    				dis.removeComponent(gauge);
		    				gauge = new Gauge("Rate",0,300, config);
		    				dis.addComponentAsFirst(gauge);
		    				dis.setComponentAlignment(gauge, Alignment.MIDDLE_CENTER);
		    				Notification.show("Rescaling Gauge", Notification.TYPE_TRAY_NOTIFICATION);
		    				} catch (Exception e){}
		    				
		    			} else {
		    				try {
		    					ui.push();
		    				} catch (Exception e){}
		    			}
		    			
		    		}
		    		
		        try {
					Thread.sleep(1000);
				} catch (Error e) {
					e.printStackTrace();
				} catch (Exception e) {

				}
		    	}
		    }
		};
		new Thread(s).start();
		addComponent(initialGauge);
		addComponent(sample);
		 
		this.setMargin(true);
		this.setSpacing(true);

		this.setSizeFull();
		this.setComponentAlignment(sample, Alignment.BOTTOM_CENTER);
		this.setComponentAlignment(initialGauge, Alignment.MIDDLE_CENTER);
		

	}
	
	public void addPreviewWindow(JSONObject json){
		if (preview!=null){
			preview.close();
		}
		VerticalLayout subContent = new VerticalLayout();
		try{
			JsonContainer dataSource = JsonContainer.Factory.newInstance(json.toString());
			Table table = new Table();
			table.setSizeFull();
			table.setContainerDataSource(dataSource);
			subContent.addComponent(table);
		}
		catch (Exception e){
			Label label = new Label();
			label.setStyleName("preview");
			label.setValue(json.toString());
			subContent.addComponent(label);
		}
			
		Window subWindow = new Window("Preview Window");
        
        subContent.setMargin(true);
        subWindow.setContent(subContent);
        subWindow.setWidth(50, Unit.PERCENTAGE);
        subWindow.setHeight(50, Unit.PERCENTAGE);
        
        // Put some components in it
        
        
        // Center it in the browser window
        subWindow.center();
        preview = subWindow;
        
        // Open it in the UI
        UI.getCurrent().addWindow(subWindow);
	}


}
