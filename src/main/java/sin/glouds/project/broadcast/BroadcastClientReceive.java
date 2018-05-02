package sin.glouds.project.broadcast;

import java.awt.Desktop;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.URI;

import com.google.gson.Gson;

import sin.glouds.util.StringUtil;

public class BroadcastClientReceive {

	public static void main(String[] args) throws IOException {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int port = 10812;// 开启监听的端口
				DatagramSocket ds = null;
				DatagramPacket dp = null;
				byte[] buf = new byte[1024];// 存储发来的消息
				StringBuffer sbuf = new StringBuffer();
				try {
					// 绑定端口的
					ds = new DatagramSocket(port);
					dp = new DatagramPacket(buf, buf.length);
					System.out.println("监听广播端口打开：");
					while(true) {
						ds.receive(dp);
						ds.close();
						int i;
						for (i = 0; i < 1024; i++) {
							if (buf[i] == 0) {
								break;
							}
							sbuf.append((char) buf[i]);
						}
						System.out.println("收到广播消息：" + sbuf.toString());
						System.out.println(dp.getAddress());
						System.out.println(dp.getPort());
						MessageSende sende = new Gson().fromJson(sbuf.toString(), MessageSende.class);
						if(sende != null && StringUtil.isNotEmpty(sende.getWelcomeUrl())) {
							if(Desktop.isDesktopSupported()) {
								Desktop.getDesktop().browse(new URI(sende.getWelcomeUrl()));
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("按任意键退出");
		System.in.read();
		thread.interrupt();
	}
}
