package sin.glouds.test.vaudio;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;

public class Ftv implements ControllerListener{
	
	private Frame frame;
	private Player player;
	private Component visual;
	private Component control = null;
	
	public static void main(String[] args) {
		Ftv ftv = new Ftv();
		ftv.play();
		
	}
	
	public void play() {
		frame = new Frame("JMF Sample1");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				if(player != null) {
					player.close();
				}
				System.exit(0);
			}
		});
		frame.setSize(500, 400);
		frame.setVisible(true);
		
		URL url = null;
		
		try {
			url = new URL("file:/E:/123.mp3");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			player = Manager.createPlayer(url);
		} catch (NoPlayerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		player.addControllerListener(this);
		player.realize();
		player.start();
	}
	
	private int videoWidth = 0;
	private int videoHeight = 0;
	private int controlHeight = 30;
	private int insetWidth = 10;
	private int insetHeight = 30;

	@Override
	public void controllerUpdate(ControllerEvent ce) {
		if(ce instanceof RealizeCompleteEvent) {
			player.prefetch();
		} else if (ce instanceof PrefetchCompleteEvent) {
			if(visual != null) {
				return;
			}
			if((visual = player.getVisualComponent()) != null) {
				Dimension size = visual.getPreferredSize();
				videoWidth = size.width;
				videoHeight = size.height;
				frame.add(visual);
			} else {
				videoWidth = 320;
			}
			if((control = player.getControlPanelComponent()) != null) {
				controlHeight = control.getPreferredSize().height;
				frame.add(control, BorderLayout.SOUTH);
			}
			frame.setSize(videoWidth + insetWidth, videoHeight + controlHeight + insetHeight);
			
			frame.validate();
		} else if(ce instanceof EndOfMediaEvent) {
			player.setMediaTime(new Time(0));
			player.start();
		}
		
	}
}
