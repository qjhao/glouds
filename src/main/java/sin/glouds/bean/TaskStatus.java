package sin.glouds.bean;

import java.util.Map;

public class TaskStatus {
	
	private String message;
	private String errorCode;
	private Map<String, Object> data;
	
	public static TaskStatus SUCCESS(String message) {
		return new TaskStatus(message);
	}
	public static TaskStatus ERROR(String message) {
		return new TaskStatus(message);
	}
	
	private TaskStatus(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public TaskStatus setData(Map<String, Object> data) {
		this.data = data;
		return this;
	}
	
	
}
