package sin.glouds.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BannerDemoApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(BannerDemoApplication.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.run(args);
	}
}
