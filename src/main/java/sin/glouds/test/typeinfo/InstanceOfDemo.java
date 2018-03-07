package sin.glouds.test.typeinfo;

public class InstanceOfDemo {

	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		
	}
	
	public static void test(Object x) {
		print("Testing x of type " + x.getClass());
		print("x instanceof Base " + (x instanceof Base));
		print("x instanceof Derived " + (x instanceof Derived));
		print("Base.isInstance(x) " + Base.class.isInstance(x));
		print("Derived.isInstance(x) " + Derived.class.isInstance(x));
		
	}
}

class Base {}

class Derived extends Base {}
