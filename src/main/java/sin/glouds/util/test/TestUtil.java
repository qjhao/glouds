package sin.glouds.util.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestUtil {

	private static List<Thread> threads = new ArrayList<>();
	
	private static int rnCount;
	private static int tdCount;
	private static TestInterface interfc;

	public static void test(int count, int threadCount, TestInterface test) {
		rnCount = count;
		tdCount = threadCount;
		interfc = test;
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < count; j++) {
						test.run();
					}
				}
			});
			thread.start();
			threads.add(thread);
		}
		
	}
	
	public static void add(int count) {
		for(int i =0;i<count;i++) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < rnCount; j++) {
						interfc.run();
					}
				}
			});
			thread.start();
			threads.add(thread);
		}
		
		tdCount += count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		while(true) {
			line = sc.nextLine();
			
			if(line.startsWith("add")) {
				String[] strs = line.split(" ");
				if(strs.length < 2)
					continue;
				int count = Integer.parseInt(strs[1]);
				add(count);
			}else if("info".equals(line)) {
				System.out.println("线程数： " + tdCount + " 单线程执行次数： " + rnCount + " 执行对象名： " + interfc.getClass().getSimpleName());
			}else if("exit".equals(line)) {
				for(Thread thread : threads) {
					thread.interrupt();
				}
				break;
			}
		}
		sc.close();
	}
}
