package sin.glouds.util.check;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;

public class CheckUtil {
	@SuppressWarnings("rawtypes")
	public static String check(Object obj, Class clazz) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields;
		if(CheckConstants.objFields.containsKey(clazz)) {
			fields = CheckConstants.objFields.get(clazz);
		}else {
			fields = clazz.getDeclaredFields();
			CheckConstants.objFields.put(clazz, fields);
		}
		String result = "";
		for(Field field : fields) {
			field.setAccessible(true);
			CheckElement element;
			if(CheckConstants.fieldElement.containsKey(field)) {
				element = CheckConstants.fieldElement.get(field);
			}else {
				element = field.getAnnotation(CheckElement.class);
				CheckConstants.fieldElement.put(field, element);
			}
			if(element == null)
				continue;
			if(element.type().equals(CheckElement.TYPE_FIELD)) {
				Object object1 = field.get(obj) == null ? null : field.get(obj);
				if(!element.nullable()) {
					if(object1 == null) {
						if("".equals(element.name()))
							return field.getName() + "不能为空";
						return element.name() + "不能为空";
					}
				}
				if(field.getGenericType() != String.class)
					continue;
				String object = (String)object1;
				if(!element.nullable()) {
					if("".equals(object)) {
						if("".equals(element.name()))
							return field.getName() + "不能为空";
						return element.name() + "不能为空";
					}
				}
				if(element.length() != -1) {
					int len = element.length();
					if(object.length() > len) {
						if("".equals(element.name()))
							return field.getName() + "长度不能超过" + len;
						return element.name() + "长度不能超过" + len;
					}
				}
				if(!"".equals(element.regex()) && !"".equals(object)) {
					if(!Pattern.matches(element.regex(), object)) {
						if("".equals(element.name()))
							return field.getName() + "格式校验不通过";
						return element.name() + "格式校验不通过";
					}
				}
			}else if(CheckElement.TYPE_LIST.equals(element.type())) {
				if(element.nullable())
					continue;
				List object = (List)field.get(obj);
				if(object == null) {
					if("".equals(element.name()))
						return field.getName() + "不能为空";
					return element.name() + "不能为空";
				}
				if(element.length() != -1) {
					int len = element.length();
					if(object.size() > len) {
						if("".equals(element.name()))
							return field.getName() + "长度不能超过" + len;
						return element.name() + "长度不能超过" + len;
					}
				}
				if(object.size() > 0) {
					if(object.get(0).getClass().isPrimitive())
						continue;
					for(int i = 0; i < object.size(); i++) {
						Object ob = object.get(i);
						result = check(ob, ob.getClass());
						if(!"".equals(result))
							return result;
					}
				}
			}else if(CheckElement.TYPE_OBJECT.equals(element.type())) {
				Object object = field.get(obj);
				if(object == null) {
					if(!element.nullable()) {
						if("".equals(element.name()))
							return field.getName() + "不能为空";
						return element.name() + "不能为空";
					}else {
						continue;
					}
				}
				result = check(field.get(obj), field.getType());
				if(!"".equals(result))
					return result;
			}else {
				throw new IllegalArgumentException("请正确配置注解");
			}
		}
		return result;
	}
}
