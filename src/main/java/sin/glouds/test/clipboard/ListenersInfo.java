package sin.glouds.test.clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.FlavorListener;

public class ListenersInfo {

	public static void main(String[] args) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		FlavorListener[] listeners = clipboard.getFlavorListeners();
		for(FlavorListener listener : listeners) {
			System.out.println(listener.toString());
			System.out.println(listener.getClass().getName());
			System.out.println();
		}
	}
}
