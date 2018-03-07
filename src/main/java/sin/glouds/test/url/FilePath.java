package sin.glouds.test.url;

import java.io.File;
import java.io.IOException;

public class FilePath {
	public static void main(String[] args) throws IOException {
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(new FilePath().getClass().getSimpleName());
//		String string = new FilePath().getClass().getResource(new FilePath().getClass().getSimpleName() + ".class").toString();
//		System.out.println(string);
		
		File file = new File("src\\sin.txt");
		if(!file.exists())
			file.createNewFile();
	}
	
	public static String getSystemPath() {
		String path = System.getProperty("user.dir");
		String[] strs = path.split("\\\\");
		return strs[0] + "\\" + strs[strs.length - 1];
	}
}
