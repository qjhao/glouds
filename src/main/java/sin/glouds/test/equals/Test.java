package sin.glouds.test.equals;

/**
 * 事实证明 == 这个运算符简直是蛇皮
 * 
 * @author JohnSin
 *
 */
public class Test extends Object {

	public static void main(String[] args) {
		System.out.println(new First() == new First());
		System.out.println(new First());
		System.out.println(new Second() == new Second());
		System.out.println(new Second());
		System.out.println(new Second());
		System.out.println(new Fifth() == new Third());
		System.out.println(new Fifth().equals(new Third()));
		System.out.println(new Six() == new Six());
		Integer a = 11, b = 1_1;
		System.out.println(a == b);
		Double d = 1_1.0, e = 11.0;
		Float f = 11f, g = 1_1f;
		System.out.println(d == e);
		System.out.println(d == f.doubleValue());
		System.out.println(d.doubleValue() == f.doubleValue());
		System.out.println(f == g);
		System.out.println(new Float(11.1).doubleValue());
	}
}

class First {

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}

class Second {
	@Override
	public int hashCode() {
		return 1;
	}
}

class Third {
	@Override
	public int hashCode() {
		return 1;
	}
}

class Fourth extends First {
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}

class Fifth extends Third {
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}

class Six {

	@Override
	public boolean equals(Object obj) {
		return obj != null && this.hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		return 1;
	}
}
