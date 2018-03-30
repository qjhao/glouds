package sin.test.data;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import sin.test.data.entity.TestParent;
import sin.test.data.repository.TestParentRepository;

@SpringBootApplication
@ComponentScan("sin.test.data")
@EntityScan("sin.test.data.entity")
public class DataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);
		System.exit(0);
	}
	
	@Bean
	CommandLineRunner run(final TestParentRepository repository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				try{
					List<TestParent> parents = repository.findBySomeNumberAndTitleLike(1.1, "%tt%");
					System.out.println(parents == null?"none resuult":parents);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
	}
}
