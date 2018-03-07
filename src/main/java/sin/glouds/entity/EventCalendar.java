package sin.glouds.entity;

import java.util.Date;
import java.util.HashMap;

public class EventCalendar {
	
	public static final String LEVEL_NORMAL = "1";
	public static final String LEVEL_IMPORTANT = "2";
	public static final String LEVEL_VERY_IMPORTANT = "3";
	public static final String LEVEL_MUST = "4";
	public static final String LEVEL_ALIVE = "5";
	
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public static final HashMap<String, String> levelMaps = new HashMap() {
		{
			put("1", "无聊就去吧");
			put("2", "有空就做吧");
			put("3", "挺重要的事");
			put("4", "必须做的事");
			put("5", "只要我还活着");
		}
	};
	
	private Integer id;
	private Integer userId;
	private String title;
	private String descritpion;
	private Date createTime;
	private Date eventTime;
	private String level;
	private Date deadLine;
	private String isOverTime;
	private String isCancled;
	private String isInvaliable;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescritpion() {
		return descritpion;
	}
	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public String getIsOverTime() {
		return isOverTime;
	}
	public void setIsOverTime(String isOverTime) {
		this.isOverTime = isOverTime;
	}
	public String getIsCancled() {
		return isCancled;
	}
	public void setIsCancled(String isCancled) {
		this.isCancled = isCancled;
	}
	public String getIsInvaliable() {
		return isInvaliable;
	}
	public void setIsInvaliable(String isInvaliable) {
		this.isInvaliable = isInvaliable;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
