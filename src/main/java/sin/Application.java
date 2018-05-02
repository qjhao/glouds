package sin;


import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import sin.test.jeesite.dao.UserDao;

@SpringBootApplication
@ComponentScan(basePackages={"sin.glouds"})
public class Application {

	@Resource
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("==============================");
		System.exit(0);
	}
	
	@Bean
	CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				System.out.println(userDao.findList().size());
			}
		};
	}
	
}
