package sin.glouds.test.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class Button1 extends JFrame {

	private JButton b1 = new JButton("b1"),b2 = new JButton("b2"),b3 = new JButton("b3");
	private JTextField txt = new JTextField(10);
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = ((JButton)e.getSource()).getText();
			txt.setText(name);
		}
	}
	
	private ButtonListener bl1 = new ButtonListener();
	
	public Button1() {
		b1.addActionListener(bl1);
		b2.addActionListener(bl1);
		b3.addActionListener(bl1);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
		add(txt);
	}
	
	public static void main(String[] args) {
		run(new Button1(), 200, 150);
	}
}
