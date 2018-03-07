package sin.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import sin.chat.pool.SocketPool;

public class Server {
	public static void main(String[] args) {
		new Server().startServer();
	}
	
	@SuppressWarnings("resource")
	public void startServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(9527);
			while(true) {
				Socket socket = serverSocket.accept();
				
				SocketPool.newClient(socket);
				SocketPool.printAll("已上线", socket, false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
