package sin.glouds.test.test4g;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Jre7Test {

	public static void main(String[] args) {
		int _1_2_3_4;
		_1_2_3_4 = 1_2_3_4;
		System.out.println(_1_2_3_4);
		System.out.println(1_2_3_4);
		
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C://test")))) {
			
		} catch (IOException | ClassCastException e) {
			e.printStackTrace();
		}
	}
}
