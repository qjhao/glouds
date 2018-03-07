package sin.glouds.test.binary;

public class BinaryToInt {

	public static void main(String[] args) {
		int i = Integer.parseInt("10101", 2);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toOctalString(i));
		System.out.println(i);
		System.out.println(Integer.toHexString(i));
	}
}
