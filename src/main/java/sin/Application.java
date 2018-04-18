package sin;

import javax.annotation.Resource;

import org.quartz.Scheduler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import sin.glouds.repository.sins.TestIncRepository;
import sin.glouds.service.TestIncService;

@SpringBootApplication
@ComponentScan(basePackages={"sin.glouds.config","sin.glouds.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.exit(0);
	}
	
	@Bean
	CommandLineRunner init(final TestIncService service) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				try {
					service.increase();
				}catch(Exception e) {
					try {
						service.increase();
					}catch(Exception e2) {
						System.out.println("========");
					}
				}
			}
		};
	}
	
}

class QuartzBean {
	public void excute() {
		System.out.println(System.currentTimeMillis());
	}
}
