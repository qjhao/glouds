package sin.glouds.test.abs;

import java.lang.reflect.Constructor;

public class Sc {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Class clazz = Super.class;
		Constructor[] constructors = clazz.getConstructors();
		System.out.println(constructors.length);
		System.out.println(clazz.getSuperclass().getName());
		clazz = Object.class;
		System.out.println(clazz.getSuperclass().getName());
	}
}
