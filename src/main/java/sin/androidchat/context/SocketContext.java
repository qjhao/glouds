package sin.androidchat.context;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class SocketContext {

	public static List<Socket> sockets = new ArrayList<>();
	public static List<Thread> threads = new ArrayList<>();
	public static List<PrintWriter> writers = new ArrayList<>();
	
	public static final String SERVER_IP = "59.110.222.94";
	public static final String TEST_SERVER_IP = "192.168.8.227";
	public static final int SERVER_PORT = 10910;
	
	public static Thread mainThread;
	public static ServerSocket serverSocket;
	
	public static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	private SocketContext() {
		
	}

	public static void putMessage(String data, PrintWriter ths) {
		for(PrintWriter writer : writers) {
			if(ths.equals(writer))
				continue;
			try {
				writer.println(data);
				writer.flush();
			}catch(Exception e) {
				e.printStackTrace();
				writers.remove(writer);
			}
		}
	}
	
	public static void stop() {
		if(threads.size() > 0) {
			for(Thread thread : threads) {
				if(thread != null)
					thread.interrupt();
			}
		}
		if(mainThread != null) {
			mainThread.interrupt();
		}
	}
}
