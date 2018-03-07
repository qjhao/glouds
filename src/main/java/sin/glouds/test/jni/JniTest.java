package sin.glouds.test.jni;

public class JniTest {
	/**
	 * mingw 32位版本
	 * 需要与系统相同的版本
	 */
	public native void test();
	public static void main(String[] args) {
		System.loadLibrary("test");
		JniTest test = new JniTest();
		test.test();
	}
}
