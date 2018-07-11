package sin.glouds.config.datasource;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "localhostMysqlTestEntityManagerFactory",
		transactionManagerRef = "localhostMysqlTestTransactionManager",
		basePackages = {"sin.glouds.repository.test"}
		)
public class LocalhostMysqlTestConfig {

	@Autowired
	@Qualifier("localhostMysqlTestDataSource")
	private DataSource localhostMysqlTestDataSource;
	@Autowired
	private JpaProperties jpaProperties;
	
	@Bean(name = "localhostMysqlTestEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactory(builder).getObject().createEntityManager();
	}
	
	@Bean(name = "localhostMysqlTestEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		Map<String, String> properties = jpaProperties.getHibernateProperties(localhostMysqlTestDataSource);
		return builder.dataSource(localhostMysqlTestDataSource)
				.properties(properties)
				.packages("sin.glouds.entity.test")
				.persistenceUnit("localhostMysqlTestPersistenceUnit")
				.build();
	}
	
	@Bean(name = "localhostMysqlTestTransactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}
}
