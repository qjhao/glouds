package sin.glouds.test.pointer;

public class PointerTest {

	public static void main(String[] args) {
		Pointer pointer = new Pointer();
		Pointer pointer2 = operate(pointer);
		System.out.println(pointer.hashCode() + " | " + pointer2.hashCode());
		System.out.println(pointer.q + " | " + pointer2.q);
		System.out.println(pointer.p + " | " + pointer2.p);
	}
	
	public static Pointer operate(Pointer pointer) {
		pointer.p = 110;
		pointer.q = 120;
		return pointer;
	}
}

class Pointer{
	int p;
	int q;
}
