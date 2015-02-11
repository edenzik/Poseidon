package com.flow.ui.main;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.RequestHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;



@Push()
@SuppressWarnings("serial")
@Theme("valo")
public class MainUI extends UI {

	@WebServlet(value = {"/*"}, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MainUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	final VerticalLayout layout = new VerticalLayout();

	@Override
	protected void init(VaadinRequest request) {
		
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				//layout.addComponent(new Label("MOO"));
				read();
			}
		});
		layout.addComponent(button);
		new InitializerThread().start();



	}
	
	private void read(){
		try {
			URL myservice = new URL("http://localhost:5050");
			InputStream openStream = myservice.openStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(openStream));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				layout.addComponent(new Label(line));
			}
		}
		catch (Exception e){}
	}
	
	class InitializerThread extends Thread {
        @Override
        public void run() {
            // Do initialization which takes some time.
            // Here represented by a 1s sleep
            try {
                Thread.sleep(1000);
                while (true){
                	read();
                	Thread.sleep(100);
                	push();

                }
            } catch (InterruptedException e) {
            }

            // Init done, update the UI after doing locking
            access(new Runnable() {
                public void run() {
                    // Here the UI is locked and can be updated
                	layout.addComponent(new Label("fsdaf"));
                	
                }
            });
        }
    }

	
}