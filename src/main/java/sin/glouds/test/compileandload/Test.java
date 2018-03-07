//package sin.glouds.test.compileandload;
//
//import java.io.File;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLClassLoader;
//import java.util.Arrays;
//
//import javax.tools.JavaCompiler;
//import javax.tools.JavaFileObject;
//import javax.tools.StandardJavaFileManager;
//
//import com.sun.tools.javac.api.JavacTool;
//
//public class Test extends ClassLoader {
//
//	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		run();
//	}
//	
//	@SuppressWarnings({ "rawtypes", "resource" })
//	public static void run() throws MalformedURLException {
//
//		JavaCompiler compiler = JavacTool.create();//ToolProvider.getSystemJavaCompiler();
//		System.out.println(compiler);
//		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
//		Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjects(new File("F:/CompileTest.java"));
//		Iterable<String> options = Arrays.asList("-d", "F://compile");
//		boolean b = compiler.getTask(null, fileManager, null, options, null, files).call();
//		System.out.println(b);
//		if(b) {
//			try {
//				ClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:///F://compile/")},ClassLoader.getSystemClassLoader());
//				Class clazz = classLoader.loadClass("CompileTest");
//				System.out.println(clazz.getName());
//				Object object = null;
//				try {
//					object = clazz.newInstance();
//				} catch (InstantiationException | IllegalAccessException e1) {
//					e1.printStackTrace();
//				}
//				Method[] methods = clazz.getDeclaredMethods();
//				for(Method method : methods) {
//					System.out.println(method.getName());
//					method.setAccessible(true);
//					try {
//						method.invoke(object,(Object)new String[]{});
//					} catch (IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IllegalArgumentException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (InvocationTargetException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//	
//	}
//}
