package sin.androidchat.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import sin.androidchat.bean.SocketRequestData;
import sin.androidchat.context.SocketContext;

//@Component
//@Lazy(value = false)
public class ChatServer {

	static {
		try {
			SocketContext.mainThread = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						SocketContext.serverSocket = new ServerSocket(SocketContext.SERVER_PORT);

						while (true) {
							final Socket socket = SocketContext.serverSocket.accept();
							System.out.println("有新人加入。。。。。");
							Thread thread = new Thread(new Runnable() {

								@Override
								public void run() {
									try {
										SocketContext.sockets.add(socket);
										PrintWriter writer = new PrintWriter(socket.getOutputStream());
										BufferedReader reader = new BufferedReader(
												new InputStreamReader(socket.getInputStream()));
										SocketContext.writers.add(writer);

										String line;
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
											try {
												SocketRequestData data = SocketContext.gson.fromJson(line,
														SocketRequestData.class);
												switch (data.getCommond()) {
												case "message":
													SocketContext.putMessage(data.getData(), writer);
													break;
												case "exit":
													break;
												default:
													break;
												}
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
										if (e instanceof SocketException && "Connection reset".equals(e.getMessage())) {
											int i = SocketContext.sockets.indexOf(socket);
											try {
												SocketContext.sockets.remove(i);
												SocketContext.writers.remove(i);
												SocketContext.threads.remove(i);
											} catch (Exception el) {
												e.printStackTrace();
											}
										}
									}
								}
							});
							SocketContext.threads.add(thread);
							thread.start();
							System.out.println("主线程启动");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			SocketContext.mainThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		if(SocketContext.mainThread != null && SocketContext.mainThread.isAlive())  {
			SocketContext.stop();
		}
	}
}
