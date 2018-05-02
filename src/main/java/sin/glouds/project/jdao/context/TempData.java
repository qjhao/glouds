package sin.glouds.project.jdao.context;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class TempData {
	public static HashMap<Class<?>, List<Field>> fields = new HashMap<>();
}
