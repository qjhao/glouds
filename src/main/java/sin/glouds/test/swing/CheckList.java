package sin.glouds.test.swing;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static sin.glouds.test.swing.SwingConsole.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CheckList extends JFrame {
	private String[] flavors = {
			"Chocolate", "Strawberry", "Vanilla Fudge Swirl",
			"Mint Chip", "Mocha Alond Fudge", "Rum Raisin",
			"Praline Cream", "Mud Pie"
	};
	private DefaultListModel<String> lItems = new DefaultListModel<>();
	private JList<String> lst = new JList<>(lItems);
	private JTextArea t = new JTextArea(flavors.length, 20);
	private JButton b = new JButton("Add Item");
	private int count = 0;
	private ActionListener b1 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(count < flavors.length) {
				lItems.add(0, flavors[count++]);
			}else {
				b.setEnabled(false);
			}
		}
	};
	private ListSelectionListener ll = new ListSelectionListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(e.getValueIsAdjusting())
				return;
			t.setText("");
			for(Object item : lst.getSelectedValues()) {
				t.append(item + "\n");
			}
		}
	};
	public CheckList() {
		t.setEditable(false);
		setLayout(new FlowLayout());
		Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK);
		lst.setBorder(brd);
		t.setBorder(brd);
		
		for(int i=0;i<4;i++) {
			lItems.addElement(flavors[count++]);
		}
		add(t);
		add(lst);
		add(b);
		
		lst.addListSelectionListener(ll);
		b.addActionListener(b1);
	}
	public static void main(String[] args) {
		run(new CheckList(), 250, 375);
	}
}
