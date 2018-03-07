package sin.glouds.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.google.gson.Gson;

public class BroadcastClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 广播的实现 :由客户端发出广播，服务器端接收
		String host = "255.255.255.255";// 广播地址
		int port = 10811;// 广播的目的端口
		MessageReceive receive = new MessageReceive();
		receive.setCommond("getServerInfo");
		receive.setDate("1111/11/11");
		receive.setOwner("johnsin");
		String message = new Gson().toJson(receive);// 用于发送的字符串
		//String message = "test";
		try {
			InetAddress adds = InetAddress.getByName(host);
			DatagramSocket ds = new DatagramSocket();
			DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), adds, port);
			ds.send(dp);
			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
