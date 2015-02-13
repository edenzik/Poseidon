package com.flow.ui.main;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;

import org.json.JSONException;
import org.json.JSONObject;

import com.flow.server.stream.JSONStream;
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
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;


/**
 * @author edenzik
 * Main UI class which receives a stream of data from back end and displays it
 *
 */
@Push()
@SuppressWarnings("serial")
@Theme("valo")
public class MainUI extends UI {

	@WebServlet(value = {"/*"}, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MainUI.class)
	public static class Servlet extends VaadinServlet {}

	final VerticalLayout layout = new VerticalLayout();

	@Override
	protected void init(VaadinRequest request) {

		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Click Me");
		layout.addComponent(button);
		new ReaderThread().start();


	}

	class ReaderThread extends Thread {
		@Override
		public void run() {
			try {
				JSONStream stream = new JSONStream("localhost", 5050);
				stream.startRead();
				JSONObject json;
				while ((json = stream.readJSON()) != null){
					System.out.println(json);
					layout.addComponent(new Label(json.toString()));
					push();
					Thread.sleep(100);
				}
				stream.endRead();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



	private void read(){
		try {
			JSONStream stream = new JSONStream("localhost", 5050);
			stream.startRead();
			JSONObject json;
			while ((json = stream.readJSON()) != null){
				System.out.println(json);
				layout.addComponent(new Label(json.toString()));
			}
			stream.endRead();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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