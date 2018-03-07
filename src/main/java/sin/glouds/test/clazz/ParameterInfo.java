package sin.glouds.test.clazz;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class ParameterInfo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		List<ParameterInfo> infos = new ArrayList<>();
		System.out.println(infos.getClass().getName());
		Class<?> clazz = ((ArrayList)infos).getClass();
		System.out.println(((ParameterizedType)(clazz.getGenericSuperclass())).getActualTypeArguments()[0].getTypeName());
		System.out.println(clazz.getMethod("get", Integer.TYPE).getReturnType().getName());
	}
}
