package sin.glouds.test.swing;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class PanelTest extends JFrame {
	MyPanel panel = new MyPanel();
	public PanelTest() {
		add(panel);
		panel.repaint();
	}
	public static void main(String[] args) {
		run(new PanelTest(), 200, 200);
	}
}

@SuppressWarnings("serial")
class MyPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("hey", 100, 100);
	}
}
