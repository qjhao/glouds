package sin.glouds.test.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import sin.glouds.test.java8.functionalinterface.Converter;
import sin.glouds.test.java8.interfaces.Formula;
/**
 * Predicate	Predicate 接口只有一个参数，返回boolean类型。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）
 *  Function	Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）
 * Supplier		Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
 * Consumer		Consumer 接口表示执行在单个参数上的操作
 * Comparator	Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法
 * Optional		Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型
 * @author admin
 *
 */
public class Test {
	public static void main(String[] args) {

	}
	
	public static void staticFunctionAndStructorTest() {
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);
		
		String str = "java";
		Converter<String, Boolean> converter1 = str::startsWith;
		boolean b = converter1.convert("j");
		System.out.println(b);
	}
	
	public static void functionalInterfaceTest() {
		Converter<String, Integer> converter = (from)->Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);
	}
	
	public static void lambdaTest() {
		List<String> names = Arrays.asList("peter", "anna", "anni", "riven");
		Collections.sort(names, (String a,String b) -> {
			return b.compareTo(a);
		});
		
		Collections.sort(names, (String a, String b) -> a.compareTo(b));
		
		Collections.sort(names, (a,b) -> b.compareTo(a));
	}

	public static void interfaceTest() {
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};

		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));
	}
	
}
