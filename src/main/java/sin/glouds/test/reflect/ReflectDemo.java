package sin.glouds.test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("java.lang.Math");
		
		Method method = clazz.getMethod("random");
		Object object = method.invoke(clazz);
		System.out.println(object);
	}
}
