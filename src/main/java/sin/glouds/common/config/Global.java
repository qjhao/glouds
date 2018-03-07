package sin.glouds.common.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import sin.glouds.util.StringUtil;

public class Global {
	
	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<>();
	
	/**
	 * 属性文件加载对象
	 */
	private static Properties loader = new Properties();
	
	static {
		try {
			loader.load(Global.class.getClassLoader().getResourceAsStream("sins.properties"));
		} catch (IOException e) {
			throw new RuntimeException("配置文件加载失败------>jeesite.properties");
		}
	}
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtil.EMPTY);
		}
		return value;
	}
	
    /**
	 * 获取系统常量
	 * 
	 * @param key
	 * @return
	 */
	public static String getSystemProp(String key) {
		return System.getProperty(key);
	}
	
	public static String getUserDir() {
		return getSystemProp("user.dir");
	}
	
	private static String getUserHome() {
		return getSystemProp("user.home");
	}
	
	public static String getProjectDataDir() {
		return getUserHome() + getConfig("baseDataPath");
	}
}
