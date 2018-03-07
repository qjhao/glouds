package sin.glouds.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

public class StaticUtils {
	public static boolean printToFile() {
		try {
			File file = getFile();
			if(!file.exists())
				file.createNewFile();
			PrintStream writer = new PrintStream(new FileOutputStream(file, true), true);
			if(printStream == null)
				printStream = System.out;
			System.setOut(writer);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void printToConsole() {
		if(printStream != null)
			System.setOut(printStream);
	}
	
	private static PrintStream printStream;
	
	private static String filePath = "logs";
	
	private static File getFile() {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		StackTraceElement element = elements[2];
		String fileName = element.getFileName();
		fileName = fileName.substring(0, fileName.indexOf('.'));
		fileName = fileName + "Log" + DateUtils.getDateFormat(DateUtils.TYPE_SHORT).format(new Date()) + ".txt"; 
		File file = new File(filePath);
		if(!file.exists())
			file.mkdirs();
		return new File(file, fileName);
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		printToFile();
	}
}
