package test.haier.msg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class MsgPush {

	public static void main(String[] args) throws IOException {
		System.out.println("返回结果：" + pushMessage());
	}
	
	public static String pushMessage() throws IOException {
		URL url = new URL("http://10.135.12.210:4000/internalapi/hsi/shortMessageAPI/sendShortMessage");//http://10.135.12.210:4000/internalapi/hsi/shortMessageAPI/sendShortMessage
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "Bearer b9c616dd-d963-36ea-ab3a-70ba961ac6e0");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		String msg = new Gson().toJson(new Message());
		System.out.println("请求数据：" + msg);
		connection.getOutputStream().write(msg.getBytes());
		connection.getOutputStream().flush();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line, result = "";
		while ((line = reader.readLine()) != null) {
			result += line;
		}
		return result;
	}
}