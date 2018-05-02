package sin.glouds.project.jdao.context;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class JContext {
	private static Properties properties = new Properties();
	
	static {
		try {
			properties.load(JContext.class.getClassLoader().getResourceAsStream("jdaoContext.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		if(properties.containsKey(key))
			return properties.getProperty(key);
		return null;
	}
	
	public static void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}
	
	public static void setAllProperties(Map<String, String> props) {
		for(String key : props.keySet()) {
			setProperty(key, props.get(key));
		}
	}
}
