package sin.glouds.util;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import sin.glouds.job.QuartzBean;

public final class QuartzUtil {

	private static QuartzUtil quartzUtil;

	private static Scheduler scheduler;

	private QuartzUtil() {

	}

	public static Optional<QuartzUtil> getInstance() {
		if (quartzUtil == null)
			init();
		return Optional.ofNullable(quartzUtil);
	}

	private static void init() {
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			quartzUtil = new QuartzUtil();
			scheduler.start();
		} catch (SchedulerException e) {
		}
	}

	public boolean addJob(Class<? extends Job> clazz, String cron, String name, String group) {
		if (!checkParam(name, group, cron, clazz))
			return false;
		try {
			JobDetail detail = getJob(name, group);
			TriggerKey triggerKey = getTriggerKey(name, group);
			Trigger trigger = getTrigger(name, group);
			if (detail == null) {
				detail = JobBuilder.newJob(clazz).withIdentity(name, group).build();
				trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
						.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
				scheduler.scheduleJob(detail, trigger);
			} else if (trigger == null) {
				trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
						.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
				scheduler.rescheduleJob(triggerKey, trigger);
			} else {
				CronTrigger cronTrigger = (CronTrigger) trigger;
				if (!cron.equals(cronTrigger.getCronExpression())) {
					trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
							.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
					scheduler.rescheduleJob(triggerKey, trigger);
				}
			}
			return true;
		} catch (SchedulerException e) {
			return false;
		}
	}

	public boolean addJob(Class<? extends Job> clazz, String cron) {
		if (clazz == null)
			return false;
		return addJob(clazz, cron, clazz.getName(), clazz.getName());
	}

	public boolean pauseJob(String name, String group) {
		if (!checkParam(name, group))
			return false;
		try {
			if (checkJobExists(name, group))
				scheduler.pauseJob(getJobKey(name, group));
			return true;
		} catch (SchedulerException e) {
			return false;
		}
	}

	public boolean resumeJob(String name, String group) {
		if (!checkParam(name, group))
			return false;
		try {
			if (checkJobExists(name, group)) {
				scheduler.resumeJob(getJobKey(name, group));
				return true;
			}
		} catch (SchedulerException e) {
		}
		return false;
	}

	public boolean deleteJob(String name, String group) {
		if (!checkParam(name, group))
			return false;
		try {
			if (checkJobExists(name, group))
				scheduler.deleteJob(getJobKey(name, group));
			return true;
		} catch (SchedulerException e) {
			return false;
		}
	}

	public boolean runJob(String name, String group) {
		if (!checkParam(name, group))
			return false;
		try {
			if (checkJobExists(name, group)) {
				scheduler.triggerJob(getJobKey(name, group));
				return true;
			}
		} catch (SchedulerException e) {
		}
		return false;
	}

	public boolean updateJob(String name, String group, String cron) {
		if (!checkParam(name, group, cron))
			return false;
		try {
			if (checkJobExists(name, group)) {
				Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
						.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
				scheduler.rescheduleJob(getTriggerKey(name, group), trigger);
			}
		} catch (SchedulerException e) {
		}
		return false;
	}

	public boolean shutdown() {
		try {
			if (!scheduler.isShutdown())
				scheduler.shutdown();
			return true;
		} catch (SchedulerException e) {
		}
		return false;
	}

	public boolean pauseAllJob() {
		try {
			scheduler.pauseAll();
			return true;
		} catch (SchedulerException e) {
		}
		return false;
	}

	public boolean start() {
		try {
			if (!scheduler.isStarted())
				scheduler.start();
			return true;
		} catch (SchedulerException e) {
		}
		return false;
	}

	public boolean checkJobExists(String name, String group) {
		if (!checkParam(name, group))
			return false;
		try {
			return scheduler.checkExists(JobKey.jobKey(name, group));
		} catch (SchedulerException e) {
			return false;
		}
	}

	private JobDetail getJob(String name, String group) {
		if (!checkParam(name, group))
			return null;
		try {
			return scheduler.getJobDetail(getJobKey(name, group));
		} catch (SchedulerException e) {
		}
		return null;
	}

	private Trigger getTrigger(String name, String group) {
		if (!checkParam(name, group))
			return null;
		try {
			return scheduler.getTrigger(getTriggerKey(name, group));
		} catch (SchedulerException e) {
		}
		return null;
	}

	private JobKey getJobKey(String name, String group) {
		return JobKey.jobKey(name, group);
	}

	private TriggerKey getTriggerKey(String name, String group) {
		return TriggerKey.triggerKey(name, group);
	}

	private boolean checkParam(String name, String group, String cron, Class<? extends Job> clazz) {
		return name != null && !"".equals(name) && group != null && !"".equals(group) && cron != null
				&& !"".equals(cron) && clazz != null;
	}

	private boolean checkParam(String name, String group) {
		return name != null && !"".equals(name) && group != null && !"".equals(group);
	}

	private boolean checkParam(String name, String group, String cron) {
		return name != null && !"".equals(name) && group != null && !"".equals(group) && cron != null
				&& !"".equals(cron);
	}

	public static void main(String[] args) {

		System.out.println(getInstance().get().addJob(QuartzBean.class, "0/1 * * * * ?", "hello", "hello"));

		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(getInstance().get().updateJob("hello", "hello", "0/2 * * * * ?"));

		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(getInstance().get().deleteJob("hello", "hello"));
		System.out.println(getInstance().get().shutdown());
	}

}
