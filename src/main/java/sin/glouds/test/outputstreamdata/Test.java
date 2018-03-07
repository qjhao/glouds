package sin.glouds.test.outputstreamdata;

import java.io.Console;
import java.io.PrintStream;

public class Test {

	public static void main(String[] args) {
		PrintStream print = System.err;
		System.setOut(print);
		System.out.println("asdf");
		Console console = System.console();
		String string = console.readLine();
		System.out.println(string);
	}
}
