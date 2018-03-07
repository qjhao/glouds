package sin.glouds.test.superclass;

public class SuperTest {

	public static void main(String[] args) {
		System.out.println(Runnable.class.getSuperclass().getName());
		System.out.println(Enum.class.getSuperclass().getName());
		System.out.println(Object.class.getSuperclass().getName());
	}
	
}
