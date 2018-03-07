package sin.deskapp.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;

import sin.deskapp.panel.ChatPanel;
import sin.deskapp.window.DasWindow;

public class MyMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String MENU_FILE = "文件";
	private final String MENU_WINDOW = "窗口";
	private final String MENU_TOOL = "工具";
	private final String MENU_HELP = "帮助";
	
	private MyMenu fileMenu = new MyMenu(MENU_FILE);
	private MyMenu windowMenu = new MyMenu(MENU_WINDOW);
	private MyMenu toolMenu = new MyMenu(MENU_TOOL);
	private MyMenu helpMenu = new MyMenu(MENU_HELP);
	
	private MyMenuItem item = new MyMenuItem("清空");
	private MyMenuItem item2 = new MyMenuItem("chat");
	
	public MyMenuBar() {
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("以吾之名：大清空术！！！！");
				DasWindow dasWindow = DasWindow.getDasWindow();
				dasWindow.remove(dasWindow.getPanel());
				dasWindow.repaint();
			}
		});
		
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DasWindow dasWindow = DasWindow.getDasWindow();
				dasWindow.remove(dasWindow.getPanel());
				dasWindow.add(new ChatPanel());
				dasWindow.repaint();
			}
		});
		
		helpMenu.add(item);
		toolMenu.add(item2);
		
		add(fileMenu);
		add(windowMenu);
		add(toolMenu);
		add(helpMenu);
	}

}
