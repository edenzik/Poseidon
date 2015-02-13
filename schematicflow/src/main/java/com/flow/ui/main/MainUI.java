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
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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
		button.addClickListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {


			}
		});

		new Thread(new ReaderRunnable()).start();

	}


	class ReaderRunnable implements Runnable {

		public void run() {
				try {
					Thread.sleep(1000);
					JSONStream stream = new JSONStream("localhost", 5050);
					while (true){
						for (JSONObject json : stream.read()) {
							System.out.println(json);
							//layout.addComponent(new Label(json.toString()));
							layout.addComponent(new Label(String.valueOf(json.has("created_at"))));
							Thread.sleep(10);
							push();
						}
						//Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

		}
	}






}