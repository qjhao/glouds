package sin.glouds.test.gc;

import java.util.ArrayList;

public class GcCrashTest {
	public static void main(String[] args) {
		ArrayList<GcTest> gcTests = new ArrayList<>();
		if(true)
			System.out.println("==");
		for(int i=1;i<10000000;i++) {
			GcTest test = new GcTest("GcTest:" + i);
			System.out.println(test.toString());
			gcTests.add(test);
		}
		System.out.println(">>>>>>>>>>>>");
	}
}

class GcTest {
	String name;
	
	public GcTest(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
}
