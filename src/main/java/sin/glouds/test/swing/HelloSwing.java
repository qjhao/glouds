package sin.glouds.test.swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloSwing {

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("glouds");
		JLabel label = new JLabel("i'm a label");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		TimeUnit.SECONDS.sleep(1);
		label.setText("i'm changing");
		JLabel label2 = new JLabel("i'm two label");
		frame.add(label2);
		frame.add(label2);
		frame.repaint();
	}
}
