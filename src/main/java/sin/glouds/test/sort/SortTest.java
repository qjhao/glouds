package sin.glouds.test.sort;

import java.util.Random;

public class SortTest {

	public static int[] insertSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return arr;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					// 接下来是无用功
					break;
				}
			}
		}
		return arr;
	}

	public static int[] bubbleSort(int[] a) {
		int temp = 0;
		for (int i = a.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (a[j + 1] < a[j]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}

	public static int[] quickSort(int[] arr, int low, int high) {
		int l = low;
		int h = high;
		int povit = arr[low];

		while (l < h) {
			while (l < h && arr[h] >= povit)
				h--;
			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}

			while (l < h && arr[l] <= povit)
				l++;

			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
		}

		// for(int i : arr) {
		// System.out.print(i + " ");
		// }
		// System.out.println();
		// System.out.print("l="+(l+1)+"h="+(h+1)+"povit="+povit+"\n");
		if (l > low)
			quickSort(arr, low, l - 1);
		if (h < high)
			quickSort(arr, l + 1, high);
		return arr;
	}

	/**
	 * *
	 * 
	 * <pre>
	 * 　*　二路归并
	 * 　*　原理：将两个有序表合并和一个有序表
	 * 　*
	 * </pre>
	 * 
	 * * * @param a * @param s * 第一个有序表的起始下标 * @param m * 第二个有序表的起始下标 * @param t
	 * * 第二个有序表的结束小标 *
	 */
	private static void merge(int[] a, int s, int m, int t) {
		int[] tmp = new int[t - s + 1];
		int i = s, j = m, k = 0;
		while (i < m && j <= t) {
			if (a[i] <= a[j]) {
				tmp[k] = a[i];
				k++;
				i++;
			} else {
				tmp[k] = a[j];
				j++;
				k++;
			}
		}
		while (i < m) {
			tmp[k] = a[i];
			i++;
			k++;
		}
		while (j <= t) {
			tmp[k] = a[j];
			j++;
			k++;
		}
		System.arraycopy(tmp, 0, a, s, tmp.length);
	}

	/**
	 * * * @param a * @param s * @param len * 每次归并的有序集合的长度
	 */
	public static void mergeSort(int[] a, int s, int len) {
		int size = a.length;
		int mid = size / (len << 1);
		int c = size & ((len << 1) - 1);
		// -------归并到只剩一个有序集合的时候结束算法-------//
		if (mid == 0)
			return;
		// ------进行一趟归并排序-------//
		for (int i = 0; i < mid; ++i) {
			s = i * 2 * len;
			merge(a, s, s + len, (len << 1) + s - 1);
		}
		// -------将剩下的数和倒数一个有序集合归并-------//
		if (c != 0)
			merge(a, size - c - 2 * len, size - c, size - 1);
		// -------递归执行下一趟归并排序------//
		mergeSort(a, 0, 2 * len);
	}

	public static void main(String[] args) {
		int[] arr = new int[100000];
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(200000);
		}
		int[] a = new int[arr.length];

		long beg = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++)
			a[i] = arr[i];
		long end = System.currentTimeMillis();

		System.out.println("无排序：" + (end - beg));

		long beg1 = System.currentTimeMillis();
		for (int ii = 0; ii < arr.length; ii++)
			a[ii] = arr[ii];
		quickSort(arr, 0, a.length - 1);

		long end1 = System.currentTimeMillis();

		long beg2 = System.currentTimeMillis();
		for (int j = 0; j < arr.length; j++)
			a[j] = arr[j];
		bubbleSort(a);

		long end2 = System.currentTimeMillis();

		long beg3 = System.currentTimeMillis();
		for (int ii = 0; ii < arr.length; ii++)
			a[ii] = arr[ii];
		insertSort(a);
		long end3 = System.currentTimeMillis();

		long beg4 = System.currentTimeMillis();
		for(int ii=0;ii<arr.length;ii++)
			a[ii] = arr[ii];
		mergeSort(a, 0, 1);
		long end4 = System.currentTimeMillis();
		
		System.out.println("快速排序：" + (end1 - beg1));
		System.out.println("冒泡排序：" + (end2 - beg2));
		System.out.println("插入排序：" + (end3 - beg3));
		System.out.println("归并排序：" + (end4 - beg4));
	}
}
