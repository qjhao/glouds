package sin.glouds.test.swing;

import java.awt.Label;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SubmitSwingProgram extends JFrame {

	JLabel label;
	public SubmitSwingProgram() {
	}
	
	static SubmitSwingProgram ssp;
	
	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ssp = new SubmitSwingProgram();
				ssp.add(new Label("i'm a label"));
			}
		});
		TimeUnit.SECONDS.sleep(2);
		
		SwingConsole.run(ssp, 300, 100);
		
		TimeUnit.SECONDS.sleep(2);
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ssp.label.setText("i'm changing");
			}
		});
	}
}
