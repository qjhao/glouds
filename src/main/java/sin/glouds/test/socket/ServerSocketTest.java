package sin.glouds.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSocketTest {
	private static List<Socket> sockets = new ArrayList<>();
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9527);
			while(true) {
				Socket socket = serverSocket.accept();
				if(!sockets.contains(socket))
					sockets.add(socket);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String line = "";
				while((line = reader.readLine()) != null) {
					pw.println(line);
					pw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
