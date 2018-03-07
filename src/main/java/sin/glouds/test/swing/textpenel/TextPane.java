package sin.glouds.test.swing.textpenel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class TextPane extends JFrame {
	private JButton b = new JButton("Add Text");
	private JTextPane tp = new JTextPane();
	private Random r = new Random();
	public TextPane() {
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 1; i < 10; i++) {
					tp.setText(tp.getText() + r.nextInt(10) + "\n");
				}
			}
		});
		tp.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				tp.setText(tp.getText() + "\n" + (int)e.getKeyCode());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		add(new JScrollPane(tp));
		add(BorderLayout.SOUTH, b);
	}
	
	public static void main(String[] args) {
		run(new TextPane(), 475, 425);
	}
}
