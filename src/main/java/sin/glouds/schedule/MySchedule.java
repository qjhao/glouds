package sin.glouds.schedule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedule {

	@Value("${cron.value}")
	private String cronStr;
	
	@Scheduled(cron = "${cron.scheduler.value.test}")
	public void printTime() {
		System.out.println(cronStr + "\t" + System.currentTimeMillis());
	}
}
