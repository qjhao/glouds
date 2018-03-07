package sin.glouds.test.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpInfo2 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress hostAddress = InetAddress.getByName("192.168.8.191");
		System.out.println(hostAddress.getHostName());
	}
}
