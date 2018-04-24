package sin.glouds.test.java.keyword;

import com.google.gson.Gson;

public class TransientTest {

	private transient String name;
	private String nickname;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public TransientTest(String name, String nickname) {
		this.name = name;
		this.nickname = nickname;
	}

	public static void main(String[] args) {
		TransientTest test = new TransientTest("JohnSin", "glouds");
		System.out.println(new Gson().toJson(test));
	}
	
	
}
