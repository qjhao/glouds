package sin.glouds.test.socket.socketspace;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 10910);
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		Scanner scanner = new Scanner(System.in);
		String line;
		while((line = scanner.nextLine()) != null) {
			writer.println(line);
			writer.flush();
			if("exit".equals(line))
				break;
		}
		writer.close();
		scanner.close();
		socket.close();
	}
}
