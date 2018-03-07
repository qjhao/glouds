package sin.glouds.util.oom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import sin.glouds.util.StringUtil;

public class O2OMapperUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T mapper(Object obj, Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		if(clazz.isPrimitive() && obj.getClass().isPrimitive()) {
			if(clazz == obj.getClass())
				return (T)obj;
			try {
				T t = clazz.cast(obj);
				return t;
			}catch(Exception e) {
				return null;
			}
		}
		
		T t = clazz.newInstance();
		Class objClass = obj.getClass();
		Field[] fieldsFrom = objClass.getDeclaredFields();
		for (Field field : fieldsFrom) {
			field.setAccessible(true);
			MapperElement element = field.getAnnotation(MapperElement.class);
			if (element == null)
				continue;
			if(!element.name().equals("")) {
				if(element.type().equals(MapperElement.TYPE_F2F)) {
					Method[] methods = clazz.getMethods();
					Method method = getMethodByName(methods, "set" + StringUtil.toFirstUpperCase(element.name()));
					Class[] types = method.getParameterTypes();
					if(method != null && types.length > 0 && types[0] == String.class)
						method.invoke(t, field.get(obj));
				}else if(element.type().equals(MapperElement.TYPE_O2O)) {
					Method[] methods = clazz.getMethods();
					Method method = getMethodByName(methods, "set" + StringUtil.toFirstUpperCase(element.name()));
					if(method != null) {
						Class[] types = method.getParameterTypes();
						if(types.length > 0) {
							method.invoke(t, mapper(field.get(obj), types[0]));
						}
					}
				}else if(element.type().equals(MapperElement.TYPE_L2L)) {
					Method[] methods = clazz.getMethods();
					Method method = getMethodByName(methods, "set" + StringUtil.toFirstUpperCase(element.name()));
					if(method != null) {
						Class[] types = method.getParameterTypes();
						if(types.length > 0 && types[0] == List.class) {
							List paramList = new ArrayList<>();
							List fromList = (List)field.get(obj);
							for(Object objj : fromList) {
								paramList.add(mapper(objj, ((Class)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0])));
							}
							method.invoke(t, paramList);
						}
					}
				}else if(element.type().equals(MapperElement.TYPE_FOOL)) {
					Object value = field.get(obj);
					Method[] methods = clazz.getMethods();
					Method method = getMethodByName(methods, "set" + StringUtil.toFirstUpperCase(element.name()));
					if(value != null && method != null) {
						List list = (List)value;
						Class[] types = method.getParameterTypes();
						if(list.size() > 0 && types.length > 0) {
							Class paramClass = (Class)(field.getGenericType());
							method.invoke(t, mapper(list.get(0), paramClass));
						}
					}
				}else if(element.type().equals(MapperElement.TYPE_O2F)) {
					Object value = field.get(obj);
					Method[] methods = clazz.getMethods();
					Method method = getMethodByName(methods, "set" + StringUtil.toFirstUpperCase(element.name()));
					if(value != null && method != null) {
						method.invoke(t, value.toString());
					}
				}
			}
		}
		return t;
	}

	private static Method getMethodByName(Method[] methods, String string) {
		for(Method method : methods) {
			if(method.getName().equals(string))
				return method;
		}
		return null;
	}
}
