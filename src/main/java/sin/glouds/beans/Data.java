package sin.glouds.beans;

public class Data {
	public static Data SUCCESS = new Data(true);
	public static Data FAIL = new Data(false);
	private boolean flag;
	private String message;
	private Object data;
	
	private Data(boolean flag) {
		this.flag = flag;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Object getData() {
		return data;
	}
	public Data setData(Object data) {
		this.data = data;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Data setMessage(String message) {
		this.message = message;
		return this;
	}
	
	
}
