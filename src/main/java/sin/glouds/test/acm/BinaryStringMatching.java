package sin.glouds.test.acm;

import java.util.Scanner;

public class BinaryStringMatching {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int num = cin.nextInt();
		cin.nextLine();
		int[] res = new int[num];
		for(int i = 0;i < num; i++) {
			String aaa = cin.nextLine();
			String bbb = cin.nextLine();
			int ore = 0;
			int index = 0;
			while(index != -2) {
				int xx = bbb.indexOf(aaa, index);
				if(xx == -1)
					index = -2;
				else {
					index = xx + 1;
					ore ++;
				}
			}
			res[i] = ore;
		}
		cin.close();
		for(int i=0;i<num;i++) {
			System.out.println(res[i]);
		}
	}
}
