package sin.glouds.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

	private PropertyUtil() {
		setSource("/sins.properties");
	}
	
	public static PropertyUtil propertyUtil = new PropertyUtil();
	
	private Properties properties = new Properties();
	
	public void setSource(String fileName) {
		try {
			properties.load(getClass().getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		if(properties.containsKey(key))
			return properties.getProperty(key);
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(propertyUtil.getProperty("appVersion"));
	}
}
