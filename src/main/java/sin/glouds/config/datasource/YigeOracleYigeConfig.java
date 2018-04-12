package sin.glouds.config.datasource;

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
		entityManagerFactoryRef = "yigeOracleYigeEntityManagerFactory",
		transactionManagerRef = "yigeOracleYigeTransactionManager",
		basePackages = {"sin.test.data.repository.yige"}
		)
public class YigeOracleYigeConfig {

	@Autowired
	@Qualifier("yigeOracleYigeDataSource")
	private DataSource yigeOracleYigeDataSource;
	@Autowired
	private JpaProperties jpaProperties;
	
	@Bean(name = "yigeOracleYigeEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactory(builder).getObject().createEntityManager();
	}
	
	@Bean(name = "yigeOracleYigeEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(yigeOracleYigeDataSource)
				.properties(jpaProperties.getHibernateProperties(yigeOracleYigeDataSource))
				.packages("sin.test.data.entity.yige")
				.persistenceUnit("yigeOracleYigePersistenceUnit")
				.build();
	}
	
	@Bean(name = "yigeOracleYigeTransactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}
}
