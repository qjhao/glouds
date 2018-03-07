package sin.glouds.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BroadcastSender {

	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	private static Logger logger = Logger.getLogger(BroadcastSender.class);

	// 广播的实现 :由客户端发出广播，服务器端接收
	private static String host = "10.130.236.177";// 广播地址
	private static int port = 10812;// 广播的目的端口
	private static InetAddress adds = null;
	private static DatagramSocket ds = null;

	static {
		init();
	}

	private static void init() {
		try {
			adds = InetAddress.getByName(host);
			ds = new DatagramSocket();
			System.out.println("初始化完成");
		} catch (UnknownHostException e) {
			logger.error("初始化广播发送端口失败 " + e.getMessage());
		} catch (SocketException e) {
			logger.error("初始化广播发送端口失败 " + e.getMessage());
		}
	}

	public static void sendServerInfo(MessageSende info) {
		if(ds != null) {
			String message = gson.toJson(info);
			try {
				DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), adds, port);
				ds.send(dp);
				System.out.println("发送广播成功");
			} catch (Exception e) {
				logger.error("广播发送失败 " + e.getMessage());
			}
		}else {
			logger.error("发送广播失败，初始化失败");
		}
	}
	
	public static void main(String[] args) {
		MessageSende sende = new MessageSende();
		sende.setCommond("hello");
		sende.setOwner("glouds");
		sende.setWelcomeUrl("http://www.baidu.com");
		sendServerInfo(sende);
	}

}
