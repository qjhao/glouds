package sin.glouds.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsLogUtil {
	public static JsLogUtil getLogger(String filePath, String fileName) {
		return new JsLogUtil(filePath, fileName);
	}
	
	private JsLogUtil(String filePath, String fileName) {
		if(filePath != null && !"".equals(filePath))
			this.filePath = filePath;
		if(filePath != null && !"".equals(filePath))
			this.fileName = fileName + sdfSimple.format(new Date());
		init();
	}
	
	private static String rootPath = "logs";
	private String filePath = "defaultLog";
	private String fileName = "defaultLog";
	private File file;
	private PrintWriter pw;
	
	public static void setRootPath(String root) {
		rootPath = root;
	}
	
	private void init() {
		String path = getPath();
		String filePath = path + "\\" + this.filePath + "\\" + this.fileName + ".txt";
		String dirPath = path + "\\" + this.filePath;
		File dir = new File(dirPath);
		if(!dir.exists()) {
			System.out.println(dirPath);
			System.out.println("mkdir");
			dir.mkdir();
			System.out.println(dir.exists());
		}
		file = new File(filePath);
		try {
			pw = new PrintWriter(new FileOutputStream(file, true), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private String getPath() {
		String path = System.getProperty("user.dir");
		String[] strs = path.split("\\\\");
		File dir = new File(strs[0] + "/" + rootPath);
		if(!dir.exists())
			dir.mkdirs();
		return dir.getPath();
	}
	
	public synchronized void info(String message, String logType) {
		if(pw != null) {
			pw.println(handleMessage(message, "INFO", logType));
			pw.flush();
		}
	}
	
	public synchronized void debug(String message, String logType) {
		if(pw != null) {
			pw.println(handleMessage(message, "DEBUG", logType));
			pw.flush();
		}
	}
	
	public synchronized void error(String message, String logType) {
		if(pw != null) {
			pw.println(handleMessage(message, "ERROR", logType));
			pw.flush();
		}
	}
	
	private String handleMessage(String message, String type, String logType) {
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return sdf.format(new Date()) + " " + type.toUpperCase() + " " + ste[ste.length - 1].getClassName() + ":" + ste[ste.length - 1].getLineNumber() + " | " + logType + ":" + message;
	}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat sdfSimple = new SimpleDateFormat("yyyy-MM-dd");
}
