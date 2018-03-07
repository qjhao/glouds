package sin.glouds.test.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import static sin.glouds.test.swing.SwingConsole.*;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class BorderLayout1 extends JFrame {
	public BorderLayout1() {
		add(BorderLayout.EAST, new JButton("East"));
		add(BorderLayout.WEST, new JButton("West"));
		add(BorderLayout.NORTH, new JButton("North"));
		add(BorderLayout.SOUTH, new JButton("South"));
		add(BorderLayout.CENTER, new JButton("Center"));
	}
	
	public static void main(String[] args) {
		run(new BorderLayout1(), 300, 250);
	}
}
