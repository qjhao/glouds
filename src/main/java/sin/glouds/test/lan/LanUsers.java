package sin.glouds.test.lan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

public class LanUsers {

	public static void main(String[] args) {
		String prefix = "192.168.8.";
		int suf = 1;
		
		while(suf < 255) {
			try {
				Process process = Runtime.getRuntime().exec("ping " + prefix + suf++);
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
				String line;
				while((line = reader.readLine()) != null) {
					System.out.println(line);
				}
				System.out.println("==================================");
			} catch (UnknownHostException e) {
				System.out.println(suf + "  " + e.getMessage());
			} catch (IOException e) {
				System.out.println(suf + "  " + e.getMessage());
			}
		}
	}
}
