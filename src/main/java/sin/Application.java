package sin;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import sin.glouds.entity.test.TestChild;
import sin.glouds.repository.sins.TestRepository;
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
	CommandLineRunner init(final TestRepository repository, final TestChildRepository childRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				List<TestChild> childs = childRepository.findAll();
				List<Integer> ids = new ArrayList<>();
				childs.forEach(child -> ids.add(child.getId()));
				System.out.println(repository.findAllByIdNotIn(ids).size());
			}
		};
	}
	
}
