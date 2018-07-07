package sin.glouds.config.datasource.dynamic;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 动态数据源实现类
 * 
 * @author JohnSin
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	private static final Logger logger = Logger.getLogger(DynamicDataSource.class);

	private Map<Object, Object> dataSourceMap = new HashMap<>();

	
	
	@Override
	protected Object determineCurrentLookupKey() {
		logger.info("切换数据源：" + DataSourceContextHolder.getDataSourceName());
		return DataSourceContextHolder.getDataSourceName();
	}

	@Override
	protected DataSource determineTargetDataSource() {
		String key = DataSourceContextHolder.getDataSourceName();
		logger.info("切换数据源：" + key);
		if(dataSourceMap.containsKey(key)) {
			return (DataSource) dataSourceMap.get(key);
		}
		return super.determineTargetDataSource();
	}

	public void changeDataSource(String dataSourceName, String url, String user, String password,
			String driverClassName) {
		if (!dataSourceMap.containsKey(dataSourceName)) {
			System.out.println("-=-=-=-=-=-=-=-");
			
			try {
				Class.forName(driverClassName);
				DriverManager.getConnection(url, user, password).close();;
			} catch (Exception e) {
				throw new IllegalStateException("无法连接该数据库");
			}
			
			DruidDataSource dataSource = new DruidDataSource();
			dataSource.setUrl(url);
			dataSource.setUsername(user);
			dataSource.setPassword(password);
			dataSource.setDriverClassName(driverClassName);
			dataSourceMap.put(dataSourceName, dataSource);
		}
		DataSourceContextHolder.setDataSourceName(dataSourceName);
	}

	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		super.setTargetDataSources(targetDataSources);
		this.dataSourceMap = targetDataSources;
	}
	
	

}
