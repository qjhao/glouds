package sin.glouds.test.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import static sin.glouds.test.swing.SwingConsole.*;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class GridLayout1 extends JFrame {
	public GridLayout1() {
		setLayout(new GridLayout(7, 3));
		for(int i = 0; i < 20; i++) {
			add(new JButton("Button" + i));
		}
	}
	public static void main(String[] args) {
		run(new GridLayout1(), 300, 300);
	}
}
