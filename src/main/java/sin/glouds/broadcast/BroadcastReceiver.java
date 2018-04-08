package sin.glouds.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import sin.glouds.common.Global;
import sin.glouds.util.StringUtil;

/*@Component
@Lazy(value = false)*/
public class BroadcastReceiver {

	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	private static Logger logger = Logger.getLogger(BroadcastReceiver.class);
	
	private static int port = 10811;// 开启监听的端口
	private static DatagramSocket ds = null;
	private static DatagramPacket dp = null;
	private static byte[] buf = new byte[1024];// 存储发来的消息
	private static StringBuilder sbuf = new StringBuilder();
	private static Thread thread;
	
	static {
		System.out.println("初始化广播接收");
		thread = new Thread(new Runnable() {
			public void run() {
				try {
					// 绑定端口的
					ds = new DatagramSocket(port);
					dp = new DatagramPacket(buf, buf.length);
					logger.info("监听广播端口打开：");
					while (true) {
						System.out.println("等待广播接收");
						ds.receive(dp);
						sbuf.setLength(0);
						int i;
						for (i = 0; i < 1024; i++) {
							if (buf[i] == 0) {
								break;
							}
							sbuf.append((char) buf[i]);
						}
						logger.info("收到广播消息：" + sbuf.toString());
						try {
							MessageReceive message = gson.fromJson(sbuf.toString(), MessageReceive.class);
							sendServerInfo(message);
						}catch(JsonSyntaxException e) {
							logger.debug(e.getMessage());
							System.out.println(sbuf.toString());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}
	
	private static void sendServerInfo(MessageReceive receive) {
		try {
			if(StringUtil.isNotEmpty(receive.getCommond()) && StringUtil.isNotEmpty(receive.getOwner()) && (receive.getOwner().endsWith("sin") || receive.getOwner().endsWith("Sin"))) {
				MessageSende message = new MessageSende();
				message.setCommond(receive.getCommond());
				message.setDate(receive.getDate());
				message.setOwner(receive.getOwner());
				message.setServerIp(Inet4Address.getLocalHost().getHostAddress());
				message.setServerPort(Global.getConfig("serverPort"));
				message.setServerProject(Global.getConfig("serverProject"));
				message.setWelcomeUrl("http://" + message.getServerIp() + ":" + message.getServerPort() + "/" + message.getServerProject() + "/" + "index.jsp");
				BroadcastSender.sendServerInfo(message);
			}
		}catch(UnknownHostException e) {
			logger.error("获取本机ip失败");
		}
	}
	
	@PreDestroy
	public void destory() {
		logger.info("销毁" + port + "端口的广播监听");
		if(thread != null && thread.isAlive())
			thread.interrupt();
		thread = null;
		if(ds != null && !ds.isClosed())
			ds.close();
	}
}
