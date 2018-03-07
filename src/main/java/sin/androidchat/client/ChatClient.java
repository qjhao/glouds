package sin.androidchat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import sin.androidchat.bean.SocketRequestData;
import sin.androidchat.context.SocketContext;

public final class ChatClient {

	private static Socket socket;
	private static PrintWriter writer;
	private static BufferedReader reader;

	static {
		try {
			socket = new Socket(SocketContext.SERVER_IP, SocketContext.SERVER_PORT);
			writer = new PrintWriter(socket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			new Thread(new Runnable() {
				public void run() {
					try {
						String line;
						while ((line = reader.readLine()) != null) {
							System.out.println(line);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeMessage(String message) {
		writer.println(SocketContext.gson.toJson(new SocketRequestData(message)));
		writer.flush();
	}

	private ChatClient() {

	}
	
	public static void main(String[] args) {
		writeMessage("hello");
	}
}
