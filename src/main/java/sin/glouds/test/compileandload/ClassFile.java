package sin.glouds.test.compileandload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.gson.Gson;

public class ClassFile {

	public static void main(String[] args) throws IOException, URISyntaxException {
		System.out.println(Gson.class.getProtectionDomain().getCodeSource().getLocation());
	}
	
	public static void test(Class<?> clazz) throws URISyntaxException, IOException {
		URL path = clazz.getClassLoader().getResource("");
		String[] strs = ClassFile.class.getName().split("\\.");
		String suffix = "";
		if (strs.length > 0) {
			for (String str : strs) {
				suffix = suffix + "\\" + str;
			}
		}else {
			suffix = clazz.getName() + ".class";
		}
		String fileName = new File(path.toURI()).getAbsolutePath() + suffix + ".class";
		InputStream is = new FileInputStream(new File(fileName));
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}
}
