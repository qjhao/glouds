package sin.glouds.test.socket.socketspace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private static List<Socket> sockets = new ArrayList<>();
	private static Thread mainThread;
	private static ServerSocket serverSocket;
	private static Socket socket = null;
	
	public static void main(String[] args) {
		mainThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(serverSocket == null)
					try {
						serverSocket = new ServerSocket(10910);
					} catch (IOException e2) {
						e2.printStackTrace();
						return;
					}
				while(true) {
					try {
						socket = serverSocket.accept();
						System.out.println(socket.toString() + " " + "已连接");
						sockets.add(socket);
						
						Thread thread = new Thread(new Runnable() {
							
							@Override
							public void run() {
								BufferedReader reader = null;
								try {
									reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								} catch (IOException e1) {
									e1.printStackTrace();
									return;
								}
								String line;
								try {
									while((line = reader.readLine()) != null) {
										if("exit".equals(line)) {
											if(sockets.contains(socket))
												sockets.remove(socket);
											if(sockets.size() == 0)
												stopMainThread();
											break;
										}else {
											System.out.println(this.toString() + ": " + line);
										}
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
						thread.start();
					} catch (IOException e1) {
						e1.printStackTrace();
						break;
					}
				}
				
			}
		});
		mainThread.setDaemon(false);
		mainThread.start();
	}
	
	@SuppressWarnings("deprecation")
	public static void stopMainThread() {
		if(mainThread != null)
			mainThread.stop();
	}
}
