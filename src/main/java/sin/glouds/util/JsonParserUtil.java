package sin.glouds.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParserUtil {
	
	/**
	 * 将json字符串解析为所需类型的集合
	 * 返回Object集合
	 * 使用时需做非空判断
	 * 
	 * @author glouds
	 * @see org.json.*
	 * @since java1.7
	 * @param json 要解析的字符串
	 * @param clazz 要解析成的对象类型
	 * @param root 要解析的key值
	 * @return list Object对象集合，使用时需强转
	 */
	public static List<Object> parserJsonArray(String json, Class<?> clazz, String root) {
		
		List<Object> list = new ArrayList<>();
		
		if(json.isEmpty())
			return list;
		
		if (moreThanOne(json, root) | moreThanOne(json, clazz.getName().toLowerCase()) | moreThanOne(json, clazz.getName().toLowerCase() + "s"))
			return list;
		
		if(json.contains(root)) {
			try {
				JSONObject jsonObject = new JSONObject(json);
				try{
					JSONArray object = jsonObject.getJSONArray(root);
					json = object.toString();
				}catch(Exception e) {
					try{
						JSONObject jsonObject2 = jsonObject.getJSONObject(root);
						json = jsonObject2.toString();
					}catch(Exception e1) {
						e1.printStackTrace();
						throw e1;
					}
				}
				
			}catch(Exception e) {
				JSONObject jsonObject = new JSONObject(json);
				
				Iterator<?> it = jsonObject.keys();
				
				while(it.hasNext()) {
					String jString = it.next().toString();
					if(jString.contains(clazz.getName())) {
						list.addAll(parserJsonArray(jString, clazz, root));
					}
				}
			}
		}else if(json.contains(clazz.getName().toLowerCase())) {
			try {
				JSONObject jsonObject = new JSONObject(json);
				try{
					JSONArray object = jsonObject.getJSONArray(clazz.getName().toLowerCase());
					json = object.toString();
				}catch(Exception e) {
					try{
						JSONObject jsonObject2 = jsonObject.getJSONObject(clazz.getName().toLowerCase());
						json = jsonObject2.toString();
					}catch(Exception e1) {
						e1.printStackTrace();
						throw e1;
					}
				}
				
			}catch(Exception e) {
				JSONObject jsonObject = new JSONObject(json);
				
				Iterator<?> it = jsonObject.keys();
				
				while(it.hasNext()) {
					String jString = it.next().toString();
					if(jString.contains(clazz.getName())) {
						list.addAll(parserJsonArray(jString, clazz, clazz.getName().toLowerCase()));
					}
				}
			}
		}else if(json.contains(clazz.getName().toLowerCase()+"s")) {
			try {
				JSONObject jsonObject = new JSONObject(json);
				try{
					JSONArray object = jsonObject.getJSONArray(clazz.getName().toLowerCase()+"s");
					json = object.toString();
				}catch(Exception e) {
					try{
						JSONObject jsonObject2 = jsonObject.getJSONObject(clazz.getName().toLowerCase()+"s");
						json = jsonObject2.toString();
					}catch(Exception e1) {
						e1.printStackTrace();
						throw e1;
					}
				}
				
			}catch(Exception e) {
				JSONObject jsonObject = new JSONObject(json);
				
				Iterator<?> it = jsonObject.keys();
				
				while(it.hasNext()) {
					String jString = it.next().toString();
					if(jString.contains(clazz.getName())) {
						list.addAll(parserJsonArray(jString, clazz, clazz.getName().toLowerCase()+"s"));
					}
				}
			}
		}else {
			return list;
		}
		
		Object obj = null;
		
		try{
			JSONArray jsonArray = new JSONArray(json);
			
			Field[] fields = clazz.getFields();
			Field[] privateFields = clazz.getDeclaredFields();
			
			for(int i=0;i<jsonArray.length();i++) {
				obj = clazz.newInstance();
				JSONObject jsonObject = (JSONObject)jsonArray.get(i);
				for(Field field : fields) {
					if(json.contains(field.getName())) {
						String value = jsonObject.getString(field.getName());
						field.set(obj, value);
					}
				}
				for(Field field : privateFields) {
					if(json.contains(field.getName())) {
						field.setAccessible(true);
						String value = jsonObject.getString(field.getName());
						field.set(obj, value);
					}
				}
				list.add(obj);
			}
		}catch(Exception e) {
			try{
				JSONObject jsonObject = new JSONObject(json);
				
				Field[] fields = clazz.getFields();
				Field[] privateFields = clazz.getDeclaredFields();
				
				obj = clazz.newInstance();
				for(Field field : fields) {
					if(json.contains(field.getName())) {
						String value = jsonObject.getString(field.getName());
						field.set(obj, value);
					}
				}
				for(Field field : privateFields) {
					if(json.contains(field.getName())) {
						field.setAccessible(true);
						String value = jsonObject.getString(field.getName());
						field.set(obj, value);
					}
				}
				list.add(obj);
			}catch(Exception e1) {
				
			}
		}
		return list;
	}
	
	private static boolean moreThanOne(String json, String root) {
		String string = " " + json + " ";
		return string.split(root).length > 2;
	}

	public static List<Object> parserJsonArray(String json, Class<?> clazz) {
		return parserJsonArray(json, clazz, UUID.randomUUID().toString());
	}
	
}
