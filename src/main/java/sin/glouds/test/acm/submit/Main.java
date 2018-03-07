package sin.glouds.test.acm.submit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int num = cin.nextInt();
		cin.nextLine();
		int[] res = new int[num];
		for(int i = 0;i < num; i++) {
			int numb = cin.nextInt();
			cin.nextLine();
			List<Double> list = new ArrayList<Double>();
			for (int j=0;j<numb;j++) {
				double radd = cin.nextDouble();
				list.add(radd);
			}
			Collections.sort(list);
			double length = 0;
			int count = 0;
			for(;;count++) {
				double val = list.get(numb - 1 - count);
				length += Math.sqrt(val*val - 1)*2;
				if(length >= 20)
					break;
			}
			res[i] = count + 1;
		}
		cin.close();
		for(int i=0;i<num;i++) {
			System.out.println(res[i]);
		}
	}
}