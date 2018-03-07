package test.haier.msg;

public class Message {
	private String username;
	private String password;
	private String phone;
	private String message;
	private String epid;
	private String linkid = "";
	private String subcode = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public Message() {
		this.username = "hezx4";// "hezx3";
		this.password = "Hezx48591";
		this.phone = "13625451751";// "18724763772";
		this.message = "test";
		this.epid = "123488";
	}
}
