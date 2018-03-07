package sin.glouds.test.swing.dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import static sin.glouds.test.swing.SwingConsole.run;

@SuppressWarnings("serial")
public class Dialogs extends JFrame {
	private JButton b1 = new JButton("Dialog Box");
	private MyDialog dlg = new MyDialog(null);
	public Dialogs() {
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(true);
			}
		});
		add(b1);
	}
	public static void main(String[] args) {
		run(new Dialogs(), 125, 175);
	}
}

@SuppressWarnings("serial")
class MyDialog extends JDialog {
	public MyDialog(JFrame parent) {
		super(parent, "My dialog", true);
		setLayout(new FlowLayout());
		add(new JLabel("Here is my dialog"));
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		add(ok);
		setSize(150, 125);
	}
}