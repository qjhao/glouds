package sin.test.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import sin.test.data.entity.TestParent;
import sin.test.data.repository.TestParentRepository;

@SpringBootApplication
@ComponentScan(basePackages={"sin.test.data"})
@EntityScan(basePackages={"sin.test.data.entity"})
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
					TestParent parents = repository.findOneBySomeNumberAndFlagAndTitleLike(1.1, false, "%tt%");
					System.out.println(parents == null?"none resuult":parents.getTestChild());
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
	}
}
