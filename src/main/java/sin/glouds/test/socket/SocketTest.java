package sin.glouds.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 9527);
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		Scanner sc = new Scanner(System.in);
		String line = "";
		while(!"bye".equals(line = sc.nextLine())) {
			pw.println(line);
			pw.flush();
			String back = reader.readLine();
			System.out.println(back);
		}
		socket.shutdownOutput();
		socket.shutdownInput();
		socket.close();
	}
}
