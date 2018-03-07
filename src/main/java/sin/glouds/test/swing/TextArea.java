package sin.glouds.test.swing;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class TextArea extends JFrame {

	private JButton
		b = new JButton("Add Data"),
		c = new JButton("Clear Data");
	
	private JTextArea t = new JTextArea(20, 40);
	private String m = "a:a\nb:b\n";
	
	public TextArea() {
		b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.append(m);
			}
		});
		c.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.setText("");
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(t));
		add(b);
		add(c);
	}
	
	public static void main(String[] args) {
		run(new TextArea(), 475, 425);
	}
}
