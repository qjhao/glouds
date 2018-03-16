package sin.test.spring;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sin.test.spring")
public class TextColorApplication {

	private static Logger logger = Logger.getLogger(TextColorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TextColorApplication.class, args);
		logger.info("系统启动成功");
	}
	
	@Bean
	CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				System.out.println("启动成功");
				logger.fatal("fatal");
				logger.info("info");
				logger.debug("debug");
				logger.error("error");
				logger.trace("trace");
			}
		};
	}
}
