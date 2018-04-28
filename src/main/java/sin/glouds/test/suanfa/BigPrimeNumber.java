package sin.glouds.test.suanfa;

import java.util.ArrayList;
import java.util.List;

import sin.glouds.util.FileUtil;

public class BigPrimeNumber {

	public static void main(String[] args) throws Exception {
		new BigPrimeNumber().prime();
	}

	private List<Integer> primes = new ArrayList<>();

	public void prime() throws Exception {
		long begin = System.currentTimeMillis();
		a : for (int i = 3; i < 100000000; i += 2) {
			int limit = (int) Math.sqrt(i);
			for(int p : primes) {
				if(p > limit)
					break;
				if(i % p == 0)
					continue a;
			}
			primes.add(i);
			System.out.println(i);
		}
		System.out.println("素数数量：" + primes.size());
		System.out.println("耗时： " + (System.currentTimeMillis() - begin) + "毫秒。");
		FileUtil.saveFile(primes, "H:/temp/", "primes.txt");
	}
}
