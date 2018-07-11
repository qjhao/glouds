package sin.glouds.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sin.glouds.project.command.util.CommandUtil;

@Controller
@RequestMapping("system")
public class SystemController extends BaseController {

	@RequestMapping("browse")
	@ResponseBody
	public String browse(@RequestParam(required = false) String url) {
		boolean b = CommandUtil.openDefaultBrowser(url);
		return b?"成功打开浏览器":"请检查系统是否支持默认浏览器或请求URL是否合法";
	}
	
	@RequestMapping("data")
	@ResponseBody
	public String data() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("G://temp/json.txt")));
		String result = "",line;
		while((line = reader.readLine()) != null) {
			result = result + line;
		}
		reader.close();
		return result;
	}
	
	@RequestMapping("sleepMillis")
	@ResponseBody
	public String sleepMillis(@RequestParam long millis) {
		long begin = System.currentTimeMillis();
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "success," + "millis:" + millis + " start:" + dateFormat.format(new Date(begin)) + " end:" + dateFormat.format(new Date());
	}
	
	@RequestMapping("postData")
	@ResponseBody
	public String postData() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("G://temp/json1.txt")));
		String result = "",line;
		while((line = reader.readLine()) != null) {
			result = result + line;
		}
		
		URL url = new URL("http://localhost:8888/huaren/interface/pda/purchaseInStock/savePurchase");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.getOutputStream().write(result.getBytes());
		result = "";
		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while ((line = reader.readLine()) != null) {
			result += line;
		}
		return result;
	}
}
