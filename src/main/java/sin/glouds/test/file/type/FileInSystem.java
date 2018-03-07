package sin.glouds.test.file.type;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInSystem {
	public static void main(String[] args) {
		try {
			File file = File.createTempFile("temp", ".sin", null);
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("this is the first temp file");
			fileWriter.close();
			System.out.println(file.getPath());
			
			Thread.sleep(11111);
			
			File file2 = new File(file.getPath());
			FileReader fReader = new FileReader(file2);
			BufferedReader bReader = new BufferedReader(fReader);
			System.out.println(bReader.readLine());
			bReader.close();
			
			file2.delete();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
