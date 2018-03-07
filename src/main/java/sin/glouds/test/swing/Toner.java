package sin.glouds.test.swing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class Toner extends JFrame {
	private JSlider redSlider = new JSlider(1, 255, 1);
	private JSlider greenSlider = new JSlider(1, 255, 1);
	private JSlider blueSlider = new JSlider(1, 255, 1);
	
	private JTextArea textArea = new JTextArea(5,20);
	
	ChangeListener cl = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			int red = 256 - redSlider.getValue();
			int green = 256 - greenSlider.getValue();
			int blue = 256 - blueSlider.getValue();
			textArea.setBackground(new Color(red, green, blue));
		}
	};
	
	public Toner() {
		setLayout(new FlowLayout());
		redSlider.addChangeListener(cl);
		greenSlider.addChangeListener(cl);
		blueSlider.addChangeListener(cl);
		add(redSlider);
		add(greenSlider);
		add(blueSlider);
		textArea.setBackground(new Color(255, 255, 255));
		add(textArea);
	}
	public static void main(String[] args) {
		run(new Toner(), 300, 200);
	}
}
