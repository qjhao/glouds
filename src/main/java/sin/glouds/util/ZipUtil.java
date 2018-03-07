package sin.glouds.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZipUtil {
	public static boolean isZip(File file) throws IOException {
		return isZip(new FileInputStream(file));
	}
	
	public static boolean isZip(InputStream is) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(is);
		bis.mark(2);
		byte[] header = new byte[2];
		bis.reset();
		// Judge header
		int headerData = (int) ((header[0] << 8) | header[1] & 0xFF);
		return headerData == 0x1f8b;
	}
}
