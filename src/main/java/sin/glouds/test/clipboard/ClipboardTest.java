package sin.glouds.test.clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class ClipboardTest {

	public static void main(String[] args) throws Exception {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//clipboard.setContents(new StringSelection("fffk"), null);
//		clipboard.addFlavorListener(new FlavorListener() {
//			
//			@Override
//			public void flavorsChanged(FlavorEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		Transferable transferable = clipboard.getContents(null);
		if(transferable != null) {
			if(transferable.isDataFlavorSupported(DataFlavor.stringFlavor))
				System.out.println(transferable.getTransferData(DataFlavor.stringFlavor));
		}
	}
}
