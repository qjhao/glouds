package sin.glouds.test.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static sin.glouds.test.swing.SwingConsole.*;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class TabbedPanel extends JFrame {
	private String[] flavors = {
			"Chocolate", "Strawberry", "Vanilla Fudge Swirl",
			"Mint Chip", "Mocha Alond Fudge", "Rum Raisin",
			"Praline Cream", "Mud Pie"
	};
	private JTabbedPane tabs = new JTabbedPane();
	private JTextField txt = new JTextField(20);
	public TabbedPanel() {
		int i = 0;
		for(String flavor : flavors) {
			tabs.addTab(flavor, new JButton("Tabbed pane " + i++));
		}
		tabs.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				txt.setText("Tab selected: " + tabs.getSelectedIndex());
			}
		});
		add(BorderLayout.SOUTH, txt);
		add(tabs);
	}
	public static void main(String[] args) {
		run(new TabbedPanel(), 400, 250);
	}
}
