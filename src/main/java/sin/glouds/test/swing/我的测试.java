package sin.glouds.test.swing;

public class 我的测试 {
	public void 测试() {
		System.out.println("任性的我");
	}
	
	public static void 静态测试() {
		System.out.println("静态测试");
	}
	
	public static void main(String[] args) {
		我的测试.静态测试();
		我的测试 我的测试 = new 我的测试();
		我的测试.测试();
		//我的测试.静态测试();
	}
}
