package sin.glouds.test.basetype;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseTypeTest {
	public static void main(String[] args) throws Exception {
		testt(1112);
	}
	
	public static void test(Object obj) {
		System.out.println(obj.getClass());//.getTypeName()); java 8
	}
	
	public static void testt(int i) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BaseTypeTest test = new BaseTypeTest();
		Method method = test.getClass().getMethod("setI", Integer.TYPE);
		method.invoke(test, i);
		System.out.println(test.i);
	}
	
	public int i;
	public void setI(int i) {
		this.i = i;
	}
}
