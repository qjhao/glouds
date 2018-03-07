package sin.glouds.test.ip;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetInfo {

	public static void main(String[] args) throws SocketException, UnsupportedEncodingException {
		Enumeration<NetworkInterface> infos = NetworkInterface.getNetworkInterfaces();
		while(infos.hasMoreElements()) {
			NetworkInterface interface1 = infos.nextElement();
			System.out.println(interface1.getName());
			System.out.println(interface1.isVirtual());
			System.out.println(interface1.isLoopback());
			System.out.println(interface1.isUp());
			System.out.println(interface1.getDisplayName());
			System.out.println(interface1.toString());
			System.out.println(interface1.getHardwareAddress()==null?"":new String(interface1.getHardwareAddress(), "iso8859-1"));
			System.out.println();
			Enumeration<InetAddress> is = interface1.getInetAddresses();
			while (is.hasMoreElements()) {
				InetAddress inetAddress = is.nextElement();
				System.out.println(inetAddress.getHostAddress());
				System.out.println(inetAddress.isSiteLocalAddress());
				System.out.println(inetAddress.isAnyLocalAddress());
				System.out.println(new String(inetAddress.getAddress(), "Unicode"));
				System.out.println("-------------------------------");
			}
			System.out.println("================");
			System.out.println();
			System.out.println("================");
		}
	}
}
