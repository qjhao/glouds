package sin.glouds.test.clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.concurrent.TimeUnit;

public class ListenerTest {

	public static void main(String[] args) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(new StringSelection("fffk"), null);
		clipboard.addFlavorListener(new FlavorListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void flavorsChanged(FlavorEvent e) {
				System.out.println(clipboard.getName());
				Transferable data = clipboard.getContents(null);
				if(data == null) {
					System.out.println("移除剪切板数据");
				}else {
					if(data.isDataFlavorSupported(DataFlavor.stringFlavor)) {
						System.out.println("存入剪切板数据，数据类型为字符串");
					}else if(data.isDataFlavorSupported(DataFlavor.allHtmlFlavor)) {
						System.out.println("存入剪切板数据，数据类型为Html");
					}else if(data.isDataFlavorSupported(DataFlavor.fragmentHtmlFlavor)) {
						System.out.println("存入剪切板数据，数据类型为FragmentHtml");
					}else if(data.isDataFlavorSupported(DataFlavor.imageFlavor)) {
						System.out.println("存入剪切板数据，数据类型为Image");
					}else if(data.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
						System.out.println("存入剪切板数据，数据类型为File");
					}else if(data.isDataFlavorSupported(DataFlavor.plainTextFlavor)) {
						System.out.println("存入剪切板数据，数据类型为PlainText");
					}else if(data.isDataFlavorSupported(DataFlavor.selectionHtmlFlavor)) {
						System.out.println("存入剪切板数据，数据类型为SelectionHtml");
					}else {
						System.out.println("未知的数据类型");
					}
				}
				System.out.println();
			}
		});
		FlavorListener[] listeners = clipboard.getFlavorListeners();
		for(FlavorListener listener : listeners) {
			System.out.println(listener.toString());
			System.out.println(listener.getClass().getName());
			System.out.println();
		}
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
