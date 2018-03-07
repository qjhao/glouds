package sin.deskapp.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DefaultPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DefaultPanel() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		setBackground(Color.white);
		g.setFont(new Font("宋体", Font.BOLD, 36));
		
		g.drawString("Anyone", 20, 50);
		g.drawString("is", 70, 100);
		g.drawString("awesome!!!", 100, 150);
		g.drawString("— glouds", 150, 200);
	}
}
