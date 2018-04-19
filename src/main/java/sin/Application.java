package sin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import sin.glouds.repository.dfdx.SpecificationRepository;
import sin.glouds.repository.dfdx.SysUserRepository;

@SpringBootApplication
@ComponentScan(basePackages={"sin.glouds"})
public class Application {

	@Autowired
	@Qualifier("dfdxUserRepository")
	private SysUserRepository userRepository;
	@Autowired
	private SpecificationRepository specificationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("==============================");
		System.exit(0);
	}
	
	@Bean
	CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				System.out.println(specificationRepository.findAll().get(0).getCreateBy().getName());
			}
		};
	}
	
}
