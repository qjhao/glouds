package sin.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

import sin.command.bean.RequestData;

public class Test {

	public static void main(String[] args) throws IOException {
		RequestData data = new RequestData("shutdown -s -t 0", "glouds", "sin", true);
		URL url = new URL("http://10.190.181.133:8888/sins/command/exec");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.getOutputStream().write(new Gson().toJson(data).getBytes());
		connection.getOutputStream().flush();
		String response = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			response += line;
		}
		System.out.println(response);
	}
}
