package sin.glouds.config.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
	
	@Bean(name = "yigeOracleDfdxDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.yige.oracle.dfdx")
	public DataSource yigeOracleDfdxDatasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "localhostMysqlJeesiteDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.localhost.mysql.jeesite")
	public DataSource localhostMysqlJeesiteDatasource() {
		return DataSourceBuilder.create().build();
	}
}
