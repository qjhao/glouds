package sin.deskapp.window;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sin.deskapp.menubar.DasMenuBar;
import sin.deskapp.panel.DefaultPanel;

public class DasWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static DasWindow dasWindow = new DasWindow();
	
	private JPanel panel;

	private final String TITLE = "我的应用";
	
	private DasWindow() {
		setTitle(TITLE);
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("3.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(image != null)
			setIconImage(image);
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 500, 300);
	}
	
	private void init() {
		setJMenuBar(new DasMenuBar());
		initPanel();
	}
	
	private void initPanel() {
		if(panel == null) {
			panel = new DefaultPanel();
		}
		add(panel);
	}
	
	public static DasWindow getDasWindow() {
		return dasWindow == null ? new DasWindow() : dasWindow;
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
