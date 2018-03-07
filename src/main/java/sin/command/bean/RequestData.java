package sin.command.bean;

public class RequestData {

	private String cmdStr;
	private String userName;
	private String token;
	private boolean parse;
	
	public RequestData() {
		
	}
	
	public RequestData(String cmdStr, String userName, String token, boolean parse) {
		this.cmdStr = cmdStr;
		this.userName = userName;
		this.token = token;
		this.parse = parse;
	}

	public String getCmdStr() {
		return cmdStr;
	}

	public void setCmdStr(String cmdStr) {
		this.cmdStr = cmdStr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isParse() {
		return parse;
	}

	public void setParse(boolean parse) {
		this.parse = parse;
	}

}
