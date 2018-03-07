package sin.glouds.test.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class CheckBoxes extends JFrame {
	private JTextArea t = new JTextArea(6, 15);
	private JCheckBox cb1 = new JCheckBox("Check Box 1"),
			cb2 = new JCheckBox("Check Box 2"),
			cb3 = new JCheckBox("Check Box 3");
	public CheckBoxes() {
		cb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				trace("1", cb1);
			}
		});
		cb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				trace("2", cb2);
			}
		});
		cb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				trace("3", cb3);
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(t));
		add(cb1);
		add(cb2);
		add(cb3);
	}
	
	private void trace(String b, JCheckBox cb) {
		if(cb.isSelected()) {
			t.append("Box " + b + " Selected\n");
		}else {
			t.append("Box " + b + " Cleared\n");
		}
	}
	
	public static void main(String[] args) {
		run(new CheckBoxes(), 200, 300);
	}
}
