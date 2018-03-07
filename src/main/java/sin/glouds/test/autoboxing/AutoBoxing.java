package sin.glouds.test.autoboxing;

public class AutoBoxing {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		//long sum = 0;
		Long sum = 0l;
		for(long i = 0;i<Integer.MAX_VALUE;i++) {
			sum += i;
		}
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(sum);
	}
}
