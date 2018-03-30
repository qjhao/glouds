package sin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import sin.test.freemarker.FreeMarkarDemo;

@SpringBootApplication
@ComponentScan("sin.test.freemarker")
@EntityScan(value = {"sin.test.freemarker"})
public class FreemarkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreemarkerApplication.class, args);
//		System.exit(0);
	}

	@Bean
	CommandLineRunner init(final FreeMarkarDemo demo) {

		return new CommandLineRunner() {

			public void run(String... strings) throws Exception {
				//demo.init();
			}
		};
	}
}
