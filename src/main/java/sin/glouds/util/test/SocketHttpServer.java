package sin.glouds.util.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketHttpServer implements Runnable {

	private final static int PORT = 10109;
	private ServerSocket server = null;

	public static void main(String[] args) {
		new SocketHttpServer();
	}

	public SocketHttpServer() {
		try {
			server = new ServerSocket(PORT);
			if (server == null)
				System.exit(1);
			new Thread(this).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket client = null;
				client = server.accept();
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				if(client != null) {
					String line;
					while((line = reader.readLine()) != null) {
						System.out.println(line);
					}
				}
				PrintStream writer = new PrintStream(client.getOutputStream(), true);
				writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
				writer.println();// 根据 HTTP 协议, 空行将结束头信息
				writer.close();
				closeSocket(client);
				continue;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void closeSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println(socket + "离开了HTTP服务器");
	}
}
