package sin.glouds.test.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static sin.glouds.test.swing.SwingConsole.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class SineDraw extends JPanel {
	private static final int SCALEFACTOR = 200;
	private int cycles;
	private int points;
	private double[] sines;
	public void setCycles(int newCycles) {
		cycles = newCycles;
		points = SCALEFACTOR * cycles * 2;
		sines = new double[points];
		for(int i=0;i<points;i++) {
			double radians = (Math.PI / SCALEFACTOR) * i;
			sines[i] = Math.sin(radians);
		}
		repaint();
	}
	private int[] pts;
	public SineDraw() {
		setCycles(5);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int maxWidth = getWidth();
		double hstep = (double)maxWidth / (double)points;
		int maxHeight = getHeight();
		pts = new int[points];
		for(int i=0;i<points;i++) {
			pts[i] = (int)(sines[i] * maxHeight/2 * 0.95 + maxHeight/2);
		}
		g.setColor(Color.RED);
		for(int i=1;i<points;i++) {
			int x1 = (int)((i - 1) * hstep);
			int x2 = (int)(i * hstep);
			int y1 = pts[i - 1];
			int y2 = pts[i];
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
}

@SuppressWarnings("serial")
public class SineWave extends JFrame {
	private SineDraw sines = new SineDraw();
	private JSlider adjustCycles = new JSlider(1, 30, 5);
	public SineWave() {
		add(sines);
		adjustCycles.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				sines.setCycles(((JSlider)e.getSource()).getValue());
			}
		});
		add(BorderLayout.SOUTH, adjustCycles);
	}
	public static void main(String[] args) {
		run(new SineWave(), 700, 400);
	}
}
