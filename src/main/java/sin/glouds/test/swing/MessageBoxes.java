package sin.glouds.test.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import static sin.glouds.test.swing.SwingConsole.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MessageBoxes extends JFrame {
	private JButton[] btns = {
			new JButton("Alert"),new JButton("Yes/No"),
			new JButton("Color"),new JButton("Input"),
			new JButton("3 Vals")
	};
	private JTextField txt = new JTextField(15);
	private ActionListener al = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = ((JButton)e.getSource()).getText();
			switch (id) {
			case "Alert":
				JOptionPane.showMessageDialog(null, "There's a bug on you!", "Hey!", JOptionPane.ERROR_MESSAGE);
				break;
			case "Yes/No":
				JOptionPane.showConfirmDialog(null, "or no", "choose yes", JOptionPane.YES_NO_OPTION);
				break;
			case "Color":
				Object[] options = {"Red", "Green"};
				int sel = JOptionPane.showOptionDialog(null, "Choose a Color!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if(sel != JOptionPane.CLOSED_OPTION) {
					txt.setText("Color Selected: " + options[sel]);
				}
				break;
			case "Input":
				String val = JOptionPane.showInputDialog("How many fingers do you see?");
				txt.setText(val);
				break;
			case "3 Vals":
				Object[] selections = {"First", "Second", "Third"};
				Object vals = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, selections, selections[0]);
				if(vals != null) {
					txt.setText(vals.toString());
				}
			default:
				break;
			}
		}
	};
	public MessageBoxes() {
		setLayout(new FlowLayout());
		for(int i=0;i<btns.length;i++) {
			btns[i].addActionListener(al);
			add(btns[i]);
		}
		add(txt);
	}
	public static void main(String[] args) {
		run(new MessageBoxes(), 200, 200);
	}
}
