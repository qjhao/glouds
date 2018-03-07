package sin.glouds.util.check;

import java.lang.reflect.Field;
import java.util.HashMap;

public class CheckConstants {
	@SuppressWarnings("rawtypes")
	public static HashMap<Class, Field[]> objFields = new HashMap<>();
	public static HashMap<Field, CheckElement> fieldElement = new HashMap<>();
}
