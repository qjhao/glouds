package test.haier.msg;

public class MessageReceive {

	private String phoneNo;
	private String epid;
	private String linkid;
	private String status;
	private String time;
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEpid() {
		return epid;
	}
	public void setEpid(String epid) {
		this.epid = epid;
	}
	public String getLinkid() {
		return linkid;
	}
	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public MessageReceive(String phoneNo, String epid, String linkid, String status, String time) {
		super();
		this.phoneNo = phoneNo;
		this.epid = epid;
		this.linkid = linkid;
		this.status = status;
		this.time = time;
	}

}
