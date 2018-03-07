package sin.glouds.util.threadpool;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TaskManager {
	private TaskManager(Class<? extends Task> clazz) {
		this.clazz = clazz;
	}
	
	private TaskManager(Class<? extends Task> clazz, int size) {
		this.clazz = clazz;
		this.size = size;
	}
	
	private Queue<Task> taskList;
	private int size = 10;
	private Class<? extends Task> clazz;
	
	public Task getTask() {
		Queue<Task> tasks = getTaskList();
		if(tasks != null && tasks.size() > 0)
			return tasks.poll();
		return null;
	}
	
	private Queue<Task> getTaskList() {
		if(taskList == null || taskList.size() == 0) {
			initTaskList();
		}
		return taskList;
	}
	
	private void initTaskList() {
		taskList = new ArrayBlockingQueue<>(size);
		for(int i=0;i<taskList.size();i++) {
			try {
				taskList.offer(clazz.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Map<Class<? extends Task>, TaskManager> taskManagers = new HashMap<>();
	
	public static void registManager(Class<? extends Task> clas) {
		if(!taskManagers.containsKey(clas))
			taskManagers.put(clas, new TaskManager(clas));
	}
	
	public static void registManager(Class<? extends Task> clas, int size) {
		if(!taskManagers.containsKey(clas))
			taskManagers.put(clas, new TaskManager(clas, size));
	}
}
