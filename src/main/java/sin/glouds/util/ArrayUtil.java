package sin.glouds.util;

public class ArrayUtil {

	public static boolean lengthEquals(Object[] arr1, Object[] arr2) {
		return (arr1 == null ? 0 : arr1.length) == (arr2 == null ? 0 : arr2.length);
	}
}
