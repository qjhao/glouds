package sin.glouds.config.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import sin.glouds.config.datasource.dynamic.DynamicDataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean(name = "localhostMysqlTestDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.localhost.mysql.test")
	public DataSource localhostMysqlTestDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "localhostMysqlSinsDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.localhost.mysql.sins")
	public DataSource localhostMysqlSinsDatasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "yigeOracleYigeDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.yige.oracle.yige")
	public DataSource yigeOracleYigeDatasource() {
		return DataSourceBuilder.create().build();
	}
//	
//	@Bean(name = "yigeOracleDfdxDataSource")
//	@ConfigurationProperties(prefix = "spring.datasource.yige.oracle.dfdx")
//	public DataSource yigeOracleDfdxDatasource() {
//		return DataSourceBuilder.create().build();
//	}
	
	@Bean(name = "localhostMysqlJeesiteDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.localhost.mysql.jeesite")
	public DataSource localhostMysqlJeesiteDatasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "dynamicDataSource")
	public DataSource dynamicDataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		dynamicDataSource.setDefaultTargetDataSource(localhostMysqlJeesiteDatasource());
		Map<Object, Object> dataSourceMap = new HashMap<>();
//		dataSourceMap.put("sins", localhostMysqlSinsDatasource());
//		dataSourceMap.put("jeesite", localhostMysqlJeesiteDatasource());
//		dataSourceMap.put("yige", yigeOracleYigeDatasource());
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setUrl("jdbc:oracle:thin:@192.168.8.10:1521:yige");
//		dataSource.setUsername("yige");
//		dataSource.setPassword("123456");
//		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		dataSourceMap.put("lalala", dataSource);
		dynamicDataSource.setTargetDataSources(dataSourceMap);
		return dynamicDataSource;
	}
}
