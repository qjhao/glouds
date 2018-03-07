package sin.glouds.test.suanfa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LongPI {
	public static int LENGTH = 440000;
	public static int NOM = LENGTH/4 + 1;
	
	public static void main(String[] args) {
		int[] s = new int[NOM+3];
		int[] w = new int[NOM+3];
		int[] v = new int[NOM+3];
		int[] q = new int[NOM+3];
		
//		init(s);
//		init(w);
//		init(v);
//		init(q);
		
//		System.out.println(s[2]);
		long sta = System.currentTimeMillis();
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File("C:\\hjb\\pi.txt"));//E:\\pi.txt
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int n = (int)(LENGTH / 1.39793 + 1);
		int k;
		w[0] = 16 * 5;
		v[0] = 4 * 239;
		
		for(k = 1;k<=n;k++) {
			div(w, 25, w);
			div(v, 239, v);
			div(v, 239, v);
			sub(w, v, q);
			div(q, 2 * k - 1, q);
			if(k % 2 == 1) {
				add(s, q, s);
			}else {
				sub(s, q, s);
			}
		}
		//System.out.println(s[0]);
		for(k = 1;k<NOM;k++) {
			int x = s[k];
			String str;
			if(x<10) {
				str = "000" + x;
			}else if(x<100) {
				str = "00" + x;
			}else if(x<1000) {
				str = "0" + x;
			}else if(x == 0) {
				str = "0000";
			}else {
				str = "" + x;
			}
			//System.out.println(str);
			try {
				fw.write(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - sta);
	}
	
	public static void init(int[] s, int a) {
		for(int i=0;i<s.length;i++)
			s[i] = a;
	}
	
	public static void init(int[] s) {
		init(s, 0);
	}
	
	public static void add(int[] a,int[] b,int[] c) {
		int i,carry = 0;
		for(i=NOM+1;i>=0;i--) {
			c[i] = a[i] + b[i] + carry;
			if(c[i] < 10000) {
				carry = 0;
			}else {
				c[i] = c[i] -10000;
				carry = 1;
			}
		}
	}
	
	public static void sub(int[] a,int[] b,int[] c) {
		int i,borrow = 0;
		for(i = NOM+1;i>=0;i--) {
			c[i] = a[i] - b[i] - borrow;
			if(c[i] >= 0) {
				borrow = 0;
			}else {
				c[i] = c[i] + 10000;
				borrow = 1;
			}
		}
	}
	
	public static void div(int[] a,int b,int[] c) {
		int i,tmp,remain = 0;
		for(i = 0;i<=NOM+1;i++) {
			tmp = a[i] + remain;
			c[i] = tmp / b;
			remain = (tmp % b) * 10000;
		}
	}
}
