package sin.test.activiti.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import sin.glouds.util.DateUtils;

@Service
public class ActivitiService {

	@Resource
	private RuntimeService runtimeService;
	@Resource
	private TaskService taskService;
	@Resource
	private RepositoryService repositoryService;
	@Resource
	private ProcessEngine processEngine;
	@Resource
	private HistoryService historyService;
	@Resource
	private IdentityService identityService;
	
	public void startProcess(String key, Map<String, Object> variables) {
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(key, variables);
		System.out.println(instance.getActivityId());
		System.out.println(instance.getBusinessKey());
		System.out.println(instance.getDeploymentId());
		System.out.println(instance.getDescription());
		System.out.println(instance.getId());
		System.out.println(instance.getLocalizedDescription());
		System.out.println(instance.getLocalizedName());
		System.out.println(instance.getName());
		System.out.println(instance.getParentId());
		System.out.println(instance.getProcessDefinitionId());
		System.out.println(instance.getProcessDefinitionKey());
		System.out.println(instance.getProcessDefinitionName());
		System.out.println(instance.getProcessInstanceId());
		System.out.println(instance.getRootProcessInstanceId());
		System.out.println(instance.getStartUserId());
		System.out.println(instance.getSuperExecutionId());
		System.out.println(instance.getTenantId());
		System.out.println(instance.getStartTime());
		System.out.println(instance.isEnded());
		System.out.println(instance.isSuspended());
		System.out.println("============================");
		List<Task> tasks = taskService.getSubTasks(key);
		for(Task task : tasks) {
			System.out.println(task.getAssignee());
			System.out.println(task.getCategory());
			System.out.println(task.getDescription());
			System.out.println(task.getExecutionId());
			System.out.println(task.getFormKey());
			System.out.println(task.getId());
			System.out.println(task.getName());
			System.out.println(task.getOwner());
			System.out.println(task.getParentTaskId());
			System.out.println(task.getPriority());
			System.out.println(task.getProcessDefinitionId());
			System.out.println(task.getProcessInstanceId());
			System.out.println(task.getTaskDefinitionKey());
			System.out.println(task.getTenantId());
			System.out.println(task.getCreateTime());
			System.out.println(task.getTaskLocalVariables());
			System.out.println("-------------------------------");
		}
	}
	
	public void taskMessage() {
		taskService.createTaskQuery().list().forEach(obj -> {
			System.out.println("启动者：" + obj.getAssignee());
			System.out.println("创建时间：" + DateUtils.getDefaultDateFormat().format(obj.getCreateTime()));
			System.out.println("任务名称：" + obj.getName());
			System.out.println("任务ID：" + obj.getId());
			System.out.println("流程ID：" + obj.getProcessInstanceId());
			System.out.println("=====================================");
		});
	}
	
	public void completeTask() {
		taskMessage();
		System.out.println("---------------------------------");
		identityService.setAuthenticatedUserId("glouds");
		Task task = taskService.createTaskQuery().list().get(0);
		taskService.complete(task.getId());
		System.out.println("-------------------------------");
		taskMessage();
	}
	
	public void processMessage() {
		runtimeService.createProcessInstanceQuery().list().forEach(obj -> {
			System.out.println("流程ID：" + obj.getId());
			System.out.println("流ID：" + obj.getActivityId());
			System.out.println("流程名称：" + obj.getName());
			System.out.println("本地名称：" + obj.getLocalizedName());
			System.out.println("定义名称：" + obj.getProcessDefinitionName());
			System.out.println("关键字：" + obj.getProcessDefinitionKey());
			System.out.println("================================");
		});
	}
	
	public void createProcess() {
		identityService.setAuthenticatedUserId("glouds");
		ProcessInstance instance = runtimeService.startProcessInstanceByKey("myProcess");
		System.out.println(instance.getActivityId());
		System.out.println(instance.getBusinessKey());
		System.out.println(instance.getDeploymentId());
		System.out.println(instance.getDescription());
		System.out.println(instance.getId());
		System.out.println(instance.getLocalizedDescription());
		System.out.println(instance.getLocalizedName());
		System.out.println(instance.getName());
		System.out.println(instance.getParentId());
		System.out.println(instance.getProcessDefinitionId());
		System.out.println(instance.getProcessDefinitionKey());
		System.out.println(instance.getProcessDefinitionName());
		System.out.println(instance.getProcessInstanceId());
		System.out.println(instance.getRootProcessInstanceId());
		System.out.println(instance.getStartUserId());
		System.out.println(instance.getSuperExecutionId());
		System.out.println(instance.getTenantId());
		System.out.println(instance.getStartTime());
		System.out.println(instance.isEnded());
		System.out.println(instance.isSuspended());
		System.out.println("============================");
		List<Task> tasks = taskService.getSubTasks(instance.getId());
		for(Task task : tasks) {
			System.out.println(task.getAssignee());
			System.out.println(task.getCategory());
			System.out.println(task.getDescription());
			System.out.println(task.getExecutionId());
			System.out.println(task.getFormKey());
			System.out.println(task.getId());
			System.out.println(task.getName());
			System.out.println(task.getOwner());
			System.out.println(task.getParentTaskId());
			System.out.println(task.getPriority());
			System.out.println(task.getProcessDefinitionId());
			System.out.println(task.getProcessInstanceId());
			System.out.println(task.getTaskDefinitionKey());
			System.out.println(task.getTenantId());
			System.out.println(task.getCreateTime());
			System.out.println(task.getTaskLocalVariables());
			System.out.println("-------------------------------");
		}
	}
}
