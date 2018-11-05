package sin;


import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"sin.glouds", "sin.mymusic", "sin.test"})
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		System.out.println("==============================");
//		System.exit(0);
	}
	
	//@Bean
	CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				String command = "cmd /c start http://localhost:8082/sins";
				try {
					Runtime.getRuntime().exec(command);
				} catch (IOException e) {
				}
			}
		};
	}
	
}
