package sin.command.bean;

public class ResponseData {

	private String cmdStr;
	private boolean parse;
	private String result;
	private boolean success;
	
	public ResponseData() {
		
	}
	
	public ResponseData(String cmdStr, boolean parse, String result, boolean success) {
		this.cmdStr = cmdStr;
		this.parse = parse;
		this.result = result;
		this.success = success;
	}

	public String getCmdStr() {
		return cmdStr;
	}

	public void setCmdStr(String cmdStr) {
		this.cmdStr = cmdStr;
	}

	public boolean isParse() {
		return parse;
	}

	public void setParse(boolean parse) {
		this.parse = parse;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
