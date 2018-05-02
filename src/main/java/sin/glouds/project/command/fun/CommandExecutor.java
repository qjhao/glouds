package sin.glouds.project.command.fun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sin.glouds.project.command.bean.RequestData;
import sin.glouds.project.command.bean.ResponseData;

public class CommandExecutor {

	public static ResponseData exec(RequestData data) {
		System.out.println(data.getCmdStr());
		System.out.println(data.getToken());
		System.out.println(data.getUserName());
		System.out.println(data.isParse());
		String msg = "";
		try{
			Process process = Runtime.getRuntime().exec(data.getCmdStr());
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				msg += line;
			}
			if("".equals(msg)) {
				reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					msg += line;
				}
			}
			process.destroy();
		}catch(IOException e) {
			e.printStackTrace();
		}
		ResponseData result = new ResponseData(data.getCmdStr(), data.isParse(), msg, true);
		return result;
	}
}
