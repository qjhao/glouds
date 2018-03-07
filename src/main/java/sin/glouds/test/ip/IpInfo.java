package sin.glouds.test.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpInfo {

	public static void main(String[] args) throws UnknownHostException {
		for(InetAddress ip : InetAddress.getAllByName("localhost")) {
			System.out.println(ip.getHostAddress());
			System.out.println(ip.getCanonicalHostName());
			System.out.println(ip.getHostName());
			System.out.println(ip.getAddress());
			System.out.println(ip.toString());
			System.out.println();
		}
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getCanonicalHostName());
		System.out.println(ip.getHostName());
		System.out.println(ip.getAddress());
		System.out.println(ip.toString());
	}
}
