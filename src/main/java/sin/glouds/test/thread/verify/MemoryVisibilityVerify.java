package sin.glouds.test.thread.verify;

import java.util.ArrayList;
import java.util.List;

import sin.glouds.test.thread.base.BaseThread;

public class MemoryVisibilityVerify {

	public static void main(String[] args) {
		VerifyThread t1 = new VerifyThread(), t2 = new VerifyThread(), t3 = new VerifyThread(), t4 = new VerifyThread();
		t1.setName("test-1");
		t2.setName("test-2");
		t3.setName("test-3");
		t4.setName("test-4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	

}

class VerifyThread extends BaseThread {

	private static volatile int index = 1;
	private static int size = 1;
	private static List<String> messages = new ArrayList<>();
	
	@Override
	public void run() {
		while (index < 10000)
			messages.add(System.currentTimeMillis() + " " + getName() + " " + index++);
		printMessage();
	}
	
	private static synchronized void printMessage() {
		if (size < 3)
			size++;
		else
			messages.forEach(msg -> System.out.println(msg));
	}

}
