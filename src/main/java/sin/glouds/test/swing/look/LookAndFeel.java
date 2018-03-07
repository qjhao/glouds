package sin.glouds.test.swing.look;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class LookAndFeel extends JFrame {
	private String[] choices = "Eeny Meenu Minnie Mickey Moe Larry Curly".split(" ");
	private Component[] samples = {
			new JButton("button"),
			new JTextField("textfield"),
			new JLabel("label"),
			new JCheckBox("checkbox"),
			new JRadioButton("radio"),
			new JComboBox<String>(choices),
			new JList<String>(),
	};
	
	public LookAndFeel() {
		super("Look And Feel");
		setLayout(new FlowLayout());
		for(Component component : samples) {
			add(component);
		}
	}
	
	private static void usageError() {
		System.out.println("Usage:LookAndFeel [cross|system|motif]");
		System.exit(1);
	}
	
	public static void main(String[] args) {
		if(args.length == 0)
			usageError();
		if(args[0].equals("cross")) {
			try{
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(args[0].equals("system")) {
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(args[0].equals("motif")) {
			try{
				UIManager.setLookAndFeel("com.sun.java." + "swing.plaf.motif.MotifLookAndFeel");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			usageError();
		}
		run(new LookAndFeel(), 300, 300);
	}
}
