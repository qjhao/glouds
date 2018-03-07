package sin.glouds.test.clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class Info {

	public static void main(String[] args) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		System.out.println(clipboard.getName());
	}
}
