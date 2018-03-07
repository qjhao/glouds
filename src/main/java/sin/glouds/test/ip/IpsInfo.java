package sin.glouds.test.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpsInfo {

	public static void main(String[] args) {
		for (int num = 0; num <= 255; num++) {
			final String host = "192.168.8." + num;
			new Thread() {
				public void run() {
					try {
						InetAddress hostAddress = InetAddress.getByName(host);
						if (!hostAddress.getHostName().equalsIgnoreCase(hostAddress.getHostAddress()))
							System.out.println(hostAddress.getHostName() + ":" + host);
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}
