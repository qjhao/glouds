package sin.glouds.test.desktop;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class DesktopTest {

	public static void main(String[] args) throws IOException {
		if(Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			System.out.println("是否支持浏览器：" + desktop.isSupported(Desktop.Action.BROWSE));
			System.out.println("是否支持邮件：" + desktop.isSupported(Desktop.Action.MAIL));
			System.out.println("是否支打开文件：" + desktop.isSupported(Desktop.Action.OPEN));
			System.out.println("是否支持编辑：" + desktop.isSupported(Desktop.Action.EDIT));
			System.out.println("是否支持打印：" + desktop.isSupported(Desktop.Action.PRINT));
			
			URI uri = URI.create("http://www.baidu.com");
			desktop.browse(uri);
			
			desktop.open(new File("F://temp"));
			
		}
		
		
	}
}
