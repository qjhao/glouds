package sin.glouds.test.swing;

import static sin.glouds.test.swing.SwingConsole.run;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ColorPie extends JFrame {

	private JSlider redSlider = new JSlider(1, 255, 1);
	private JSlider greenSlider = new JSlider(1, 255, 1);
	private JSlider blueSlider = new JSlider(1, 255, 1);
	
	private JPanel panel = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			int red = 256 - redSlider.getValue();
			int green = 256 - greenSlider.getValue();
			int blue = 256 - blueSlider.getValue();
			
			g.setColor(new Color(red, green, blue));
			g.fillOval(110, 110, 100, 100);
			g.setColor(new Color(255, 255, 255));
			g.fillOval(135, 135, 50, 50);
		}
	};
	
	ChangeListener cl = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			panel.repaint();
		}
	};
	
	public ColorPie() {
		redSlider.addChangeListener(cl);
		greenSlider.addChangeListener(cl);
		blueSlider.addChangeListener(cl);
		add(BorderLayout.NORTH,greenSlider);
		add(BorderLayout.SOUTH,blueSlider);
		add(BorderLayout.CENTER,panel);
	}
	public static void main(String[] args) {
		run(new ColorPie(), 300, 400);
	}

}
