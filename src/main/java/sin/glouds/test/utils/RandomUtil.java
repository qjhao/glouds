package sin.glouds.test.utils;

import java.util.Random;

public class RandomUtil {
	private static Random random;
	
	static {
		if(random == null) {
			random = new Random();
		}
	}
	
	/**
	 * 获取一个0到Integer.MAX_VALUE之间的随机浮点型数
	 * 
	 * @return double
	 */
	public static double getDouble() {
		return getDouble(0, Integer.MAX_VALUE);
	}
	
	public static double getDouble(int end) {
		return getDouble(0, end);
	}
	
	public static double getDouble(int start, int end) {
		return Double.parseDouble(Math.abs(random.nextInt(start)) + "." + Math.abs(random.nextInt(end)));
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(getDouble());
		}
	}
	
}
