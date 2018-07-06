package sin.glouds.config.datasource.dynamic;

import org.apache.log4j.Logger;

public class DataSourceContextHolder {

	public static final Logger logger = Logger.getLogger(DataSourceContextHolder.class);
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
	
	/**
	 * 获取数据源名
	 * 
	 * @param dataSourceKey
	 */
	public static void setDataSourceName(String dataSourceName) {
		logger.info("切换到{" + dataSourceName + "}数据源");
		contextHolder.set(dataSourceName);
	}
	
	/**
	 * 获取数据源名称
	 * 
	 * @return 
	 */
	public static String getDataSourceName() {
		return contextHolder.get();
	}
	
	public static void clearDataSource() {
		contextHolder.remove();
	}
}
