package sin.glouds.temp;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class UrlClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, IOException {
		URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("http://localhost:10810/toolkit/temp/test.jar")});
		Class<?> clazz = Class.forName("sin.glouds.helloworld.HelloWorld", true, classLoader);
		classLoader.close();
		Method sayHello = clazz.getMethod("sayHello");
		Object result = sayHello.invoke(clazz.newInstance());
		System.out.println(result);
	}
}
