package sin.glouds.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import sin.glouds.common.SpringContext;
import sin.glouds.service.TestService;

public class QuartzBean implements Job {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("定时调度： " + sdf.format(new Date()) + " 所在线程：" + Thread.currentThread().getName());
		TestService service = SpringContext.getBean(TestService.class);
		service.increase();
	}
	
}