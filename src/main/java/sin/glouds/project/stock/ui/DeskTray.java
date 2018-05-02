package sin.glouds.project.stock.ui;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class DeskTray {
	public static void main(String[] args) throws Exception {
		new DeskTray().test2();
	}

	public void test2() throws Exception {
		ColorPicker cp = new ColorPicker();
		SystemTray tray = SystemTray.getSystemTray();
		BufferedImage bi = ImageIO.read(new File("H:/sins/common/icons/sin.gif"));
		TrayIcon icon = new TrayIcon(bi);
		icon.setToolTip("JohnSin的小工具");
		icon.setImageAutoSize(true);
		PopupMenu popup = new PopupMenu();
		MenuItem mi = new MenuItem("退出");
		MenuItem ml = new MenuItem("显示/隐藏");
		mi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setVisible(false);
				tray.remove(icon);
				System.exit(0);
			}
		});
		ml.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setVisible(!cp.isVisible());
			}
		});
		popup.add(ml);
		popup.add(mi);
		icon.setPopupMenu(popup);
		tray.add(icon);
		cp.setVisible(true);
	}
}
