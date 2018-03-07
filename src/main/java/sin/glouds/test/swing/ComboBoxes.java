package sin.glouds.test.swing;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import static sin.glouds.test.swing.SwingConsole.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ComboBoxes extends JFrame {
	private String[] description = {
			"Ebullient", "Obtuse", "Recalcitrant", "Brilliant",
			"Somnescent", "Timorous", "Florid", "Putrescent"
	};
	private JTextField t = new JTextField(15);
	private JComboBox<String> c = new JComboBox<>();
	private JButton b = new JButton("Add items");
	private int count = 0;
	public ComboBoxes() {
		for(int i=0;i<4;i++) {
			c.addItem(description[count++]);
		}
		t.setEditable(false);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count < description.length)
					c.addItem(description[count++]);
			}
		});
		c.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				t.setText("index: " + c.getSelectedIndex() + "   " + ((JComboBox<String>)e.getSource()).getSelectedItem());
			}
		});
		setLayout(new FlowLayout());
		add(t);
		add(c);
		add(b);
	}
	public static void main(String[] args) {
		run(new ComboBoxes(), 200, 175);
	}
}
