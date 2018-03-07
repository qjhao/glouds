package sin.deskapp.socket;

import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import sin.deskapp.bean.Result;

public class ClientSocket {
	
	private static Socket socket;
	private static BufferedReader reader;
	private static PrintWriter pw;
	private static Gson gson = new Gson();
	
	public static boolean startClient() {
		if(socket != null)
			return true;
		try {
			socket = new Socket("192.168.0.9", 9527);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						try{
							String backk = reader.readLine();
							handleMsg(backk);
						}catch(Exception e) {
							
						}
					}
				}
			});
			thread.setDaemon(true);
			thread.start();
			return true;
		} catch (Exception e) {
			printMsg("client start fail");
			return false;
		}
	}
	
	private static void printMsg(String msg) {
	}

	
	public static void postMsg(String msg) {
		if(reader != null && pw != null) {
			try{
				pw.println(msg==null?"":msg);
				pw.flush();
			}catch(Exception e) {
			}
		}
	}
	
	private static void handleMsg(String msg) {
		if(msg.startsWith("result::")) {
			handleResult(msg.substring("result::".length()));
		}else {
			printMsg(msg);
		}
	}
	
	private static void handleResult(String msg) {
		System.out.println(msg);
		Result result = gson.fromJson(msg, Result.class);
		if("true".equals(result.getSuccess())) {
			if("getNickName".equals(result.getFunction()))
				setNickName(result.getData());
			else if("setNickName".equals(result.getFunction()))
				setNickName(result.getData());
		}
			
	}
	
	private static void setNickName(String nickName) {
		System.out.println(nickName);
	}
	
	public void windowClosing(WindowEvent e) {
		if(socket != null) {
			try{
				socket.shutdownOutput();
				socket.shutdownInput();
				socket.close();
			}catch(Exception ex) {
				
			}
		}
		System.exit(0);
	}
	
	public void windowOpened(WindowEvent e) {
		startClient();
	}
}
