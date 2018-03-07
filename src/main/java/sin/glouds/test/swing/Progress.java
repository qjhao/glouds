package sin.glouds.test.swing;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.ProgressMonitor;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static sin.glouds.test.swing.SwingConsole.*;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Progress extends JFrame {
	private JProgressBar pb = new JProgressBar();
	private ProgressMonitor pm = new ProgressMonitor(this, "Monitoring Progress", "Test", 0, 100);
	private JSlider sb = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
	public Progress() {
		setLayout(new GridLayout(2, 1));
		add(pb);
		pm.setProgress(0);
		pm.setMillisToPopup(10);
		sb.setValue(0);
		sb.setPaintTicks(true);
		sb.setMajorTickSpacing(20);
		sb.setMinorTickSpacing(5);
		sb.setBorder(new TitledBorder("Slide Me"));
		pb.setModel(sb.getModel());
		add(sb);
		sb.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				pm.setProgress(sb.getValue());
			}
		});
	}
	
	public static void main(String[] args) {
		run(new Progress(), 300, 200);
	}
}
