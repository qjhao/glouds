package sin.glouds.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = {
		"sin.test.jeesite" }, sqlSessionFactoryRef = "localhostMysqlJeesiteSqlSessionFactory")
public class LocalhostMysqlJeesiteConfig {

	private static final String MAPPER_LOCATION = "classpath:mybatis/mappers/localhost/mysql/jeesite/*.xml";
	private static final String MAPPER_CONFIG = "classpath:mybatis/mybatis-config.xml";
	@Autowired
	@Qualifier("localhostMysqlJeesiteDataSource")
	private DataSource datasource;

	@Bean(name = "localhostMysqlJeesiteSqlSessionFactory")
	public SqlSessionFactory localhostMysqlJeesiteSqlSessionFactory() throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(datasource);
		sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(MAPPER_CONFIG));
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
		return sessionFactory.getObject();
	}

	@Bean(name = "localhostMysqlJeesiteDatasourceTrancationManager")
	public DataSourceTransactionManager localhostMysqlJeesiteDataSourceTranscationManager() {
		return new DataSourceTransactionManager(datasource);
	}
}
