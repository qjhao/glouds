package sin.androidchat.bean;

public class SocketRequestData {

	private String commond;
	private String data;
	
	public SocketRequestData() {
		
	}
	
	public SocketRequestData(String message) {
		this.commond = "message";
		this.data = message;
	}

	public String getCommond() {
		return commond;
	}

	public void setCommond(String commond) {
		this.commond = commond;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
