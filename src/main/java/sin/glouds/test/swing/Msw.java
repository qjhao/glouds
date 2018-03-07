package sin.glouds.test.swing;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Msw {

	public static void main(String[] args) throws IOException, URISyntaxException {
		new Msw();
	}
	public Msw() {
		JFrame frmGlouds = new JFrame();
		frmGlouds.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qinjianhao\\Pictures\\e6875ab5c9ea15ce0e6ce393b3003af33887b2e2.jpg"));
		frmGlouds.setSize(new Dimension(379, 259));
		frmGlouds.setVisible(true);
		frmGlouds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGlouds.setTitle("glouds");
		
		JDesktopPane desktopPane = new JDesktopPane();
		frmGlouds.getContentPane().add(desktopPane, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		frmGlouds.setJMenuBar(menuBar);
		
		JMenu 开始 = new JMenu("New menu");
		开始.setActionCommand("开始");
		menuBar.add(开始);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		开始.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
	}
}
