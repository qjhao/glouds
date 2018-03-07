package sin.glouds.test.security;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SecurityManager manager = System.getSecurityManager();
		System.out.println(manager.getInCheck());
		manager.checkConnect("192.168.8.163", 8080);
		System.out.println(manager.getInCheck());
	}
}
