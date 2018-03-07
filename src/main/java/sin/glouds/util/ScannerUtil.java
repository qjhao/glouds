package sin.glouds.util;

import java.util.Scanner;

public final class ScannerUtil {

	private ScannerUtil(){
		
	}
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static int nextInt() {
		return scanner.nextInt();
	}
	
	public static String nextString() {
		return scanner.next();
	}
	
	public static String nextLine() {
		return scanner.nextLine();
	}
	
	public static int nextLineAsInt() {
		return Integer.parseInt(scanner.nextLine());
	}
	
	public static double nextDouble() {
		return scanner.nextDouble();
	}
	
	public static double nextLineAsDouble() {
		return Double.parseDouble(scanner.nextLine());
	}
	
	public static boolean nextBoolean() {
		return scanner.nextBoolean();
	}
	
	public static int nextLineAsBoolean() {
		return Integer.parseInt(scanner.nextLine());
	}
}
