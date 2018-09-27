package sin.glouds.test.process;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Demo {

	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe");
		Map<String, String> environment = builder.environment();
		environment.keySet().forEach(key -> {
			System.out.println(key + " : " + environment.get(key));
		});
		Process process = builder.start();
		TimeUnit.SECONDS.sleep(5);
		process.destroy();
	}
}
