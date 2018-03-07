package sin.chat.pool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public class SocketPool {
	private static List<Runnable> runnables = new ArrayList<>();
	private static List<Socket> sockets = new ArrayList<>();
	@SuppressWarnings({ "serial" })
	private static HashMap<String, String> clients = new HashMap<String, String>() {
		{
			put("192.168.87.1", "wuzp");
			put("10.190.181.133", "glouds");
		}
	};
	public static void newClient(final Socket socket) {
		sockets.add(socket);
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try{
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String line = "";
					while((line = reader.readLine()) != null) {
						handleMsg(line, socket);
					}
					sockets.remove(socket);
					socket.shutdownOutput();
					socket.shutdownInput();
					socket.close();
					printAll("已下线", socket, false);
				}catch(Exception e) {
					if(e.getClass() == SocketException.class) {
						printAll("的网络崩了！！", socket, false);
						sockets.remove(socket);
					}
				}
			}

		});
		
		runnables.add(thread);
		thread.start();
	}
	
	public static void printAll(String msg) {
		for(Socket socket : sockets) {
			try {
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(msg);
				pw.flush();
			} catch (IOException e) {
				sockets.remove(socket);
			}
		}
	}
	
	public static void printAll(String msg, Socket sock, boolean isTalk) {
		System.out.println(msg);
		for(Socket socket : sockets) {
//			if(sock == socket)
//				continue;
			try {
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println((clients.containsKey(sock.getInetAddress().getHostAddress())?clients.get(sock.getInetAddress().getHostAddress()):sock.getInetAddress().getHostAddress()) + (isTalk?":":"") + msg);
				pw.flush();
			} catch (IOException e) {
				sockets.remove(socket);
			}
		}
	}
	
	@SuppressWarnings("unused")
	private static void printBlank(Socket socket) {
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("");
			pw.flush();
		} catch (IOException e) {
			sockets.remove(socket);
		}
	}
	
	private static void handleMsg(String line, Socket socket) {
		if(line.startsWith("command::")) {
			String result = handleMsg(line.substring("command::".length()), socket.getInetAddress().getHostAddress());
			printBack(result, socket);
		}else {
			printAll(line, socket, true);
		}
	}
	
	private static Gson gson = new Gson();
	
	private static String handleMsg(String line, String ip) {
		Params params = gson.fromJson(line, Params.class);
		Result result = new Result();
		if("getNickName".equals(params.getFunction())) {
			result.setSuccess("true");
			result.setData(getNickName(ip));
			result.setFunction("getNickName");
		}else if("setNickName".equals(params.getFunction())) {
			String para = params.getPara();
			String original = clients.containsKey(ip)?clients.get(ip):ip;
			clients.put(ip, para);
			printAll(original + "已更名为：" + para);
			result.setSuccess("true");
			result.setData(para);
			result.setFunction("setNickName");
		}
		return "result::" + gson.toJson(result);
	}
	
	private static void printBack(String msg, Socket socket) {
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(msg);
			pw.flush();
		} catch (IOException e) {
			sockets.remove(socket);
		}
	}
	
	private static String getNickName(String ip) {
		return clients.containsKey(ip) ? clients.get(ip) : ip;
	}
}

class Params {
	private String function;
	private String para;
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	
	
}

class Result {
	private String success;
	private String data;
	private String function;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getFunction() {
		return function;
	}
	
	public void setFunction(String function) {
		this.function = function;
	}
	
}
