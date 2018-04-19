package sin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import sin.glouds.common.SpringContext;

@SpringBootApplication
@ComponentScan(basePackages={"sin.glouds.common"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("==============================");
	}
	
	@Bean
	CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				System.out.println(SpringContext.getProperty("cron.job.value.quartzBean"));
			}
		};
	}
	
}
