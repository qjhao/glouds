package sin;


import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import sin.glouds.config.datasource.dynamic.DynamicDataSource;
import sin.glouds.repository.test.TestChildRepository;

@SpringBootApplication
@ComponentScan(basePackages={"sin.glouds", "sin.mymusic", "sin.test"})
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		System.out.println("==============================");
		System.exit(0);
	}
	
	@Bean
	CommandLineRunner init(final TestChildRepository repository, final DynamicDataSource dynamicDataSource) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				System.out.println(repository.findAll().size());
				System.out.println(dynamicDataSource.getConnection().getMetaData().getDatabaseProductName());
				dynamicDataSource.changeDataSource("lalala", "jdbc:oracle:thin:@192.168.8.10:1521:yige", "yige", "123456", "oracle.jdbc.driver.OracleDriver");
				System.out.println(dynamicDataSource.getConnection().getMetaData().getDatabaseProductName());
				dynamicDataSource.changeDataSource("hahaha", "jdbc:oracle:thin:@192.168.8.10:1521:yige", "yige", "123", "oracle.jdbc.driver.OracleDriver");
				System.out.println(dynamicDataSource.getConnection().getMetaData().getDatabaseProductName());
			}
		};
	}
	
}
