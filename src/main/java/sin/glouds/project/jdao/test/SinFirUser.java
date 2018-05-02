package sin.glouds.project.jdao.test;

import sin.glouds.project.jdao.annotation.Row;

public class SinFirUser {
	@Row
	private Integer id;
	@Row
	private String name;
	@Row
	private String pwd;
	@Row
	private String createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public SinFirUser(Integer id, String name, String pwd, String createTime) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.createTime = createTime;
	}
	public SinFirUser() {
		
	}
}
