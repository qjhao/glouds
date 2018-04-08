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
