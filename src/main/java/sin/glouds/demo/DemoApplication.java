package sin.glouds.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
	public String greeting() {
		return "Hello World!";
	}
	
	@RequestMapping("/greeting/{username}")
	public String userGreeting(@PathVariable("username") String username) {
		return String.format("Hello %s", username);
	}
	
	@RequestMapping("/age/{age}")
	public String age(@PathVariable("age") int age) {
		return String.format("I'm %d", age);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
