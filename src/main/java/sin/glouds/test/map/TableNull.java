package sin.glouds.test.map;

import java.util.Hashtable;
import java.util.Map.Entry;

public class TableNull {
	public static void main(String[] args) {
		Hashtable<String, String> table = new Hashtable<>();
		table.put(null, "");
		System.out.println(table.size());
		table.put("key", null);
		System.out.println(table.size());
		table.put(null, null);
		System.out.println(table.size());
		table.put("", null);
		System.out.println(table.size());
		
		for(Entry<String, String> entry : table.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println(table.toString());
	}
}
