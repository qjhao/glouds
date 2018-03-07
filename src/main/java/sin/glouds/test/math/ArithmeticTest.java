package sin.glouds.test.math;

public class ArithmeticTest {

	public static void main(String[] args) {
		int a = 2;
		a += a -= ++a * a++;
		//2 += 2 -= 3 * 3
		//a+= --a;
		System.out.println(a);
	}
}
