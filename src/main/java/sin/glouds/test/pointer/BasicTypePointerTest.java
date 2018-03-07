package sin.glouds.test.pointer;

public class BasicTypePointerTest {

	public static void main(String[] args) {
		Boolean b = new Boolean(true);
		reverse(b);
		System.out.println(b);
	}
	
	public static void reverse(Boolean b) {
		b = !b;
	}
}
