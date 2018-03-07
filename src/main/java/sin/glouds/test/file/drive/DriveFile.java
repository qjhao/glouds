package sin.glouds.test.file.drive;

import java.io.File;

public class DriveFile {

	public static void main(String[] args) {
		File file = new File("C:/");
		File file2 = file.listFiles()[0].listFiles()[0];
		System.out.println(file2.getPath());
		System.out.println(file2.isDirectory());
		System.out.println(file2.exists());
		System.out.println(file2.isHidden());
		System.out.println(file2.listFiles().length);
	}
}
