package sin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import sin.test.activiti.service.ActivitiService;

@SpringBootApplication
@ComponentScan("sin.test.activiti")
@EntityScan("sin.test.activiti.model")
@EnableJpaRepositories("sin.test.activiti.repository")
public class ActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiApplication.class, args);
//		System.exit(0);
	}

	@Bean
	CommandLineRunner init(final ActivitiService activitiService) {

		return new CommandLineRunner() {

			public void run(String... strings) throws Exception {
				activitiService.taskMessage();
			}
		};
	}
}
