package sin.glouds.config.datasource.dynamic;

import java.sql.SQLException;
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
			DruidDataSource dataSource = new DruidDataSource();
			dataSource.setUrl(url);
			dataSource.setUsername(user);
			dataSource.setPassword(password);
			dataSource.setDriverClassName(driverClassName);
			dataSourceMap.put(dataSourceName, dataSource);
			setTargetDataSources(dataSourceMap);
			try {
				System.out.println(dataSource.getConnection().getMetaData().getDatabaseProductName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DataSourceContextHolder.setDataSourceName(dataSourceName);
		try {
			System.out.println(getConnection().getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		super.setTargetDataSources(targetDataSources);
		this.dataSourceMap = targetDataSources;
	}
	
	

}
