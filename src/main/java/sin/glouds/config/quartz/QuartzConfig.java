package sin.glouds.config.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sin.glouds.util.QuartzUtil;

@Configuration
public class QuartzConfig {

	@Bean(name = "scheduler")
	public QuartzUtil scheduler() {
		return QuartzUtil.getInstance().get();
	}
	
}
