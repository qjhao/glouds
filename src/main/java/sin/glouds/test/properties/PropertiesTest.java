package sin.glouds.test.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		InputStream is = Object.class.getResourceAsStream("/constants.properties");
		properties.load(is);
		System.out.println(properties.getProperty("name"));
	}
}
