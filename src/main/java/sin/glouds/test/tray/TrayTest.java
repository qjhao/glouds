package sin.glouds.test.tray;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TrayTest extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2797642619847353439L;

	public static void main(String[] args) throws Exception {
		new TrayTest().test2();
	}
	
	public void test2() throws Exception {
		BufferedImage bi = ImageIO.read(new File("F:/sins/sins/common/icons/sin.gif"));
		TrayIcon icon = new TrayIcon(bi);
		icon.setToolTip("托盘图标");
		icon.setImageAutoSize(true);
		SystemTray tray = SystemTray.getSystemTray();
		tray.add(icon);
		
	}
	
	public void test() throws Exception {
		SystemTray tray = SystemTray.getSystemTray();
		String path = "F:\\sins\\sins\\img\\20170816";
		int index = 1;
		for(TrayIcon icon : tray.getTrayIcons()) {
			File file = new File(path + index++ + ".jpg");
			Image image = icon.getImage();
			
			BufferedImage bi = new BufferedImage(image.getWidth(this), image.getHeight(this), BufferedImage.TYPE_3BYTE_BGR);
			Graphics g = bi.getGraphics();
			g.drawImage(image, image.getWidth(this), image.getHeight(this), null);
			System.out.println(ImageIO.write(bi, "jpg", file));
		}
	}
}
