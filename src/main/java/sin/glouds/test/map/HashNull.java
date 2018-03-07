package sin.glouds.test.map;

import java.util.HashMap;
import java.util.Map;

public class HashNull {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("key", null);
		System.out.println(map.size());
		map.put(null, null);
		System.out.println(map.size());
		map.put("", null);
		System.out.println(map.size());
		
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println(map.toString());
	}
}
