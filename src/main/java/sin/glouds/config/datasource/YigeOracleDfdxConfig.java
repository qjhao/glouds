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
		entityManagerFactoryRef = "yigeOracleDfdxEntityManagerFactory",
		transactionManagerRef = "yigeOracleDfdxTransactionManager",
		basePackages = {"sin.glouds.repository.dfdx"}
		)
public class YigeOracleDfdxConfig {

	@Autowired
	@Qualifier("yigeOracleDfdxDataSource")
	private DataSource yigeOracleDfdxDataSource;
	@Autowired
	private JpaProperties jpaProperties;
	
	@Bean(name = "yigeOracleDfdxEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactory(builder).getObject().createEntityManager();
	}
	
	@Bean(name = "yigeOracleDfdxEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(yigeOracleDfdxDataSource)
				.properties(jpaProperties.getHibernateProperties(yigeOracleDfdxDataSource))
				.packages("sin.glouds.entity.dfdx")
				.persistenceUnit("yigeOracleDfdxPersistenceUnit")
				.build();
	}
	
	@Bean(name = "yigeOracleDfdxTransactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}
}
