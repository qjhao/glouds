package sin.glouds.test.swing;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class TurningSquare extends JFrame {
	private JSlider speed = new JSlider(1, 100, 1);
	private JSlider rad = new JSlider(100, 200, 100);
	
	public TurningSquare() {
		final MySquare square = new MySquare();
		
		add(square);
		
		speed.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider)e.getSource()).getValue();
				square.setPyl(value);
			}
		});
		
		rad.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider)e.getSource()).getValue();
				square.setRad(value);
			}
		});
		add(BorderLayout.NORTH, speed);
		add(BorderLayout.SOUTH, rad);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				square.repaint();
			}
		}, 100, 10);
	}
	
	public static void main(String[] args) {
		run(new TurningSquare(), 500, 500);
	}
}

@SuppressWarnings("serial")
class MySquare extends JPanel {
	private int count = 1000;
	private int x0 = 200;
	private int y0 = 200;
	private int rad = 100;
	private double[] radis = new double[count];
	private int i = 0;
	private int pyl = 1;
	
	public void setCount(int count) {
		this.count = count;
		for(int i=0;i<count;i++) {
			radis[i] = Math.PI / count * i;
		}
	}
	
	public void setPyl(int pyl) {
		this.pyl = pyl;
	}
	
	public void setRad(int rad) {
		this.rad = rad;
	}
	
	public MySquare(int count) {
		setCount(count);
	}
	
	public MySquare() {
		setCount(count);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		i = i + pyl;
		
		i = i % count;
		
		int x1 = (int)(x0 + rad * Math.sin(radis[i]));
		int y1 = (int)(y0 + rad * Math.cos(radis[i]));
		int x2 = (int)(x0 - rad * Math.cos(radis[i]));
		int y2 = (int)(y0 + rad * Math.sin(radis[i]));
		int x3 = (int)(x0 - rad * Math.sin(radis[i]));
		int y3 = (int)(y0 - rad * Math.cos(radis[i]));
		int x4 = (int)(x0 + rad * Math.cos(radis[i]));
		int y4 = (int)(y0 - rad * Math.sin(radis[i]));
		
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x1, y1, x4, y4);
		g.drawLine(x3, y3, x2, y2);
		g.drawLine(x3, y3, x4, y4);
	}
}
