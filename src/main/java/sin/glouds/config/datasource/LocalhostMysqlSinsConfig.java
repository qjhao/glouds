package sin.glouds.config.datasource;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "localhostMysqlSinsEntityManagerFactory",
		transactionManagerRef = "localhostMysqlSinsTransactionManager",
		basePackages = {"sin.glouds.repository.sins"}
		)
public class LocalhostMysqlSinsConfig {

	@Autowired
	@Qualifier("localhostMysqlSinsDataSource")
	private DataSource localhostMysqlSinsDataSource;
	@Autowired
	private JpaProperties jpaProperties;
	
	@Primary
	@Bean(name = "localhostMysqlSinsEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactory(builder).getObject().createEntityManager();
	}
	
	@Primary
	@Bean(name = "localhostMysqlSinsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(localhostMysqlSinsDataSource)
				.properties(jpaProperties.getHibernateProperties(localhostMysqlSinsDataSource))
				.packages("sin.glouds.entity.sins")
				.persistenceUnit("localhostMysqlSinsPersistenceUnit")
				.build();
	}
	
	@Primary
	@Bean(name = "localhostMysqlSinsTransactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}
}
