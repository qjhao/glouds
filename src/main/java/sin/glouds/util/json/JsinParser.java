package sin.glouds.util.json;

import java.lang.reflect.Field;

public class JsinParser {
	public static String parser(Object obj) {
		JsonRoot root = obj.getClass().getAnnotation(JsonRoot.class);
		StringBuilder sb = new StringBuilder();
		if(root == null)
			throw new IllegalArgumentException("this is not a json root class");
		else {
			Field[] fields = obj.getClass().getFields();
			sb.append("{").append("\"").append(obj.getClass().getSimpleName()).append("\":");
			for(Field field : fields) {
				if(field.getAnnotation(JsonElement.class) == null)
					continue;
				JsonElement jsonElement = field.getAnnotation(JsonElement.class);
				String value = "";
				try {
					value = field.get(obj).toString();
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}
				
				if(!jsonElement.nullable() && "".equals(value))
					throw new NullableException(field.getName() + " is nullable");
				
			}
		}
		return sb.toString();
	}
}
