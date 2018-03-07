package sin.glouds.test.socket.socketstream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import sin.glouds.util.transforstream.TransferStreamUtil;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true) {
			Socket socket = server.accept();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			String line;
//			while((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
//			reader.close();
//			socket.close();
			TransferStreamUtil.transfer(socket.getInputStream(), System.out);
			break;
		}
		server.close();
	}
}
