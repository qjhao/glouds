package sin.glouds.test.thread.white;

import java.util.concurrent.TimeUnit;

public class VolatileTest {

	volatile int i = 1;

	public static void main(String[] args) {

		VolatileTest test = new VolatileTest();
		test.prob();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(test.i);
	}
	
	public void prob() {
		for (int j = 0; j < 20; j++) {
			new Thread(new Runnable() {
				public void run() {
					for (int k = 0; k < 20; k++) {
						System.out.println(Thread.currentThread().getName() + " : " + (i++));
						try {
							TimeUnit.MICROSECONDS.sleep(20);
						} catch (InterruptedException e) {
						}
					}
				}
			}).start();
		}
	}
}
