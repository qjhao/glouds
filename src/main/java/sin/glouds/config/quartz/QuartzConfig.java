package sin.glouds.config.quartz;

import org.quartz.Trigger;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class QuartzConfig {

	public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledTask task) {
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		//是否并发执行 涉及数据库操作应设置为false
		jobDetail.setConcurrent(false);
		jobDetail.setName("name");
		jobDetail.setGroup("group");
		jobDetail.setTargetObject(task);
		jobDetail.setTargetMethod("excute");
		return jobDetail;
	}
	
	
	public CronTriggerFactoryBean cronTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setJobDetail(jobDetail.getObject());
		trigger.setCronExpression("0 30 20 * * ?");
		trigger.setName("name");
		return trigger;
	}
	
	public SchedulerFactoryBean schedulerFactory(Trigger cronTrigger) {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		bean.setOverwriteExistingJobs(true);
		bean.setStartupDelay(3);
		bean.setTriggers(cronTrigger);
		return bean;
	}
}
