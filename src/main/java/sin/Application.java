package sin;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"sin.glouds", "sin.mymusic", "sin.test"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("==============================");
	}
	
	CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
			}
		};
	}
	
}
