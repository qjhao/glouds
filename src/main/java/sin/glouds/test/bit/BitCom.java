package sin.glouds.test.bit;
/**
 * 位运算的测试类
 * 
 * @author qinjianhao
 * @version 1.0
 *
 */
public class BitCom {
	public static void main(String[] args) {
		//System.out.println(Integer.toString(1));
		compareSpeedWitharithmetic();
	}
	
	
	/**
	 * 整形数字 1 执行(Integer.MAX_VALUE)次 ×2 运算
	 * 输出算数运算与位运算的执行时间
	 * 
	 * 当数字为int型时,结果发现并不会快多少
	 * 但当数字为Integer时，算术运算的效率会慢7倍，位运算的效率更低，明显比算术运算慢
	 * 
	 * @author qinjianhao
	 * @since 1.0
	 */
	public static void compareSpeedWitharithmetic() {
		//int a = 1;
		Integer a = new Integer(1);
		
		long startc = System.currentTimeMillis();
		
		for(int i = 1;i<Integer.MAX_VALUE;i++) {
			a = a*2;
		}
		
		long endc = System.currentTimeMillis();
		
		System.out.println(endc - startc);
		
		//a = 1;
		a = new Integer(1);
		
		long startb = System.currentTimeMillis();
		
		for(int i = 1;i<Integer.MAX_VALUE;i++) {
			a = a << 1;
		}
		
		long endb = System.currentTimeMillis();
		
		System.out.println(endb - startb);
	}
	
	/**
	 * 
	 */
	public static void testCompareSpeedWithArithmetic() {
		for(int i=1;i<11;i++) {
			 compareSpeedWitharithmetic();
		 }
	}
}
