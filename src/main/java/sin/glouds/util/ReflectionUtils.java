package sin.glouds.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if ((params == null) || (params.length == 0)) {
			return Object.class;
		}
		if (!(params[0] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[0];
	}
}
