package sin.glouds.test.test4g;

public class JniTest {
	public static native void printf(String string);
	
	public static void main(String[] args) {
		printf("i`m glouds.");
	}
}
