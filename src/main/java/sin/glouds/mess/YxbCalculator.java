package sin.glouds.mess;

public class YxbCalculator {

	public static void main(String[] args) {
		double d = 8050 + (750 * 0.5 + 88 * 2.7 + 1190 *2) * 0.95;
		double e = (15000 - d)/500;
		System.out.println(d);
		System.out.println(e);
		System.out.println(1.5*270*0.95);
		System.out.println(400.0/270/0.95);
		System.out.println((400.0/270/0.95 - 1.08)*10000/300);
	}
}
