package sin.glouds.test.java8.functionalinterface;

@FunctionalInterface
public interface Converter<F,T> {
	T convert(F from);
}
