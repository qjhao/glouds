package sin.glouds.util;

import java.util.Random;
/**
 * 获取随机数的工具类，但是取值上限通常是达不到的···
 * 
 * @author glouds
 *
 */
public final class RandomUtil {

	private RandomUtil() {}
	
	private static Random random = new Random();
	
	/**
	 * 返回一个非负整数
	 * 
	 * @author glouds
	 * @return int
	 */
	public static int nextInt() {
		return nextInt(Integer.MAX_VALUE);
	}
	
	/**
	 * 返回一个非负且不大于maxValue的整数,若max不大于0则返回0
	 * 
	 * @author glouds
	 * @param maxValue
	 * @return
	 */
	public static int nextInt(int maxValue) {
		return random.nextInt(maxValue);
	}
	
	/**
	 * 若maxValue不小于minValue且maxValue不小于0，返回大于0 两者之间的整数，否则返回0
	 * 
	 * @author glouds
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	public static int nextInt(int minValue, int maxValue) {
		if(minValue < 0)
			minValue = 0;
		if(maxValue >= minValue) {
			return random.nextInt(maxValue - minValue) + minValue;
		}else {
			return 0;
		}
	}
	
	/**
	 * 返回一个非负浮点数
	 * 
	 * @author glouds
	 * @return 
	 */
	public static double nextDouble() {
		return random.nextDouble();
	}
	
	/**
	 * 返回一个非负且不大于maxValue的浮点数,若max不大于0则返回0
	 * 
	 * @author glouds
	 * @param maxValue
	 * @return
	 */
	public static double nextDouble(double maxValue) {
		if(maxValue < 0)
			return 0;
		return Math.random() * maxValue;
	}
	
	/**
	 * 若maxValue不小于minValue且maxValue不小于0，返回大于0 两者之间的浮点数，否则返回0
	 * 
	 * @author glouds
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	public static double nextDouble(double minValue, double maxValue) {
		if(minValue < 0)
			minValue = 0;
		if(maxValue >= minValue) {
			return Math.random() * (maxValue - minValue) + minValue;
		}else {
			return 0;
		}
	}
	
	/**
	 * 返回一个非负整数
	 * 
	 * @author glouds
	 * @return 
	 */
	public static int nextLong() {
		return nextLong();
	}
	
	/**
	 * 返回一个随机的boolean值
	 * 
	 * @return
	 */
	public static boolean nextBoolean() {
		return random.nextBoolean();
	}
}
