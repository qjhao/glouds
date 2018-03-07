package sin.glouds.util;

import java.util.HashMap;
import java.util.Map;

public class CNCharacterUtil {

	@SuppressWarnings({ "serial" })
	public static Map<String, Integer> xMapper = new HashMap<String, Integer>() {
		{
			put("一", 1);
			put("二", 2);
			put("三", 3);
			put("四", 4);
			put("五", 5);
			put("六", 6);
			put("七", 7);
			put("八", 8);
			put("九", 9);
			put("零", 0);
		}
	};
	
	@SuppressWarnings({ "serial" })
	public static Map<Integer, String> rMapper = new HashMap<Integer, String>() {
		{
			put(1, "一");
			put(2, "二");
			put(3, "三");
			put(4, "四");
			put(5, "五");
			put(6, "六");
			put(7, "七");
			put(8, "八");
			put(9, "九");
			put(0, "零");
		}
	};
}
