package sin.glouds.test.cycle;

public class ExceptionCycle {

	public static void main(String[] args) throws Exception {
		Exception e1,e2;
		e1 = new Exception("e1");
		e2 = new Exception("e2",e1);
//		Class clazz = Throwable.class;
//		Field field = clazz.getDeclaredField("cause");
//		field.setAccessible(true);
//		field.set(e1, e2);
		e1.initCause(e2);
		e1.printStackTrace();
	}
}
