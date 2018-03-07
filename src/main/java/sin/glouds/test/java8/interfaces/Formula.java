package sin.glouds.test.java8.interfaces;

public interface Formula {
	double calculate(int a);
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
