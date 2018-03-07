package sin.local.windows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sin.local.windows.util.CommandUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		Process process = Runtime.getRuntime().exec("ping www.baidu.com");
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("");
	}
	
	public void brower(String url) {
		CommandUtil.openDefaultBrowser(url);
	}
}
