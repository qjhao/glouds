package sin.glouds.test.beautiful;

public class MyPractice {

	public static boolean isBissextile(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}

	public static String mark(int score) {
		switch (score / 10) {
		case 9:
			return "A";
		case 8:
			return "A";
		case 7:
			return "A";
		case 6:
			return "A";
		default:
			return "E";
		}
	}
	
	public static double pi(int length) {
		double pi = 0;
		for(int i=0;i<length;i++) {
			pi = pi + ((i % 2 == 0 ? 1 : -1) * 4.0 / (2 * i + 1));
			System.out.println(pi);
		}
		return pi;
	}
	
	public static void main(String[] args) {
		System.out.println(pi(1000));
	}
}
