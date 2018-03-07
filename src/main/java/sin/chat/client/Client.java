package sin.chat.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.google.gson.Gson;

public class Client extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4061397906568411746L;

	public static void main(String[] args) {
		new Client();
	}
	
	public Client() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		pane = new JScrollPane(textArea);
		this.add(pane);
		JPanel jPanel = new JPanel();
		textField = new JTextField(30);
		JButton button = new JButton("发送");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		jPanel.setLayout(new FlowLayout());
		jPanel.add(textField);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					send();
			}
		});
		jPanel.add(button);
		this.add(jPanel, BorderLayout.SOUTH);
		setTitle("XxoO");
		setSize(450, 600);
		setLocation(50, 100);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(socket != null) {
					try{
						socket.shutdownOutput();
						socket.shutdownInput();
						socket.close();
					}catch(Exception ex) {
						
					}
				}
				System.exit(0);
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
				startClient();
			}
		});
		setVisible(true);
		getNickName();
	}
	
	private Gson gson = new Gson();
	
	private void getNickName() {
		if(!startClient())
			return;
		Params params = new Params();
		params.setFunction("getNickName");
		params.setPara("");
		String json = gson.toJson(params);
		String msg = "command::" + json;
		postMsg(msg);
	}
	
	private void setNickName(String nickName) {
		this.setTitle(nickName);
		System.out.println(nickName);
		repaint();
	}

	private static Socket socket;
	private static BufferedReader reader;
	private static PrintWriter pw;
	private static JTextArea textArea;
	private static JTextField textField;
	private static JScrollPane pane;
	
	private boolean startClient() {
		if(socket != null)
			return true;
		try {
			socket = new Socket("10.190.181.133", 9527);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						try{
							String backk = reader.readLine();
							handleMsg(backk);
						}catch(Exception e) {
							
						}
					}
				}
			});
			thread.setDaemon(true);
			thread.start();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			printMsg("client start fail");
			return false;
		}
	}
	
	
	private static void printMsg(String msg) {
		if(!"".equals(msg))
			textArea.append(msg + "\n");
		textArea.selectAll();
	}
	
	private void handleMsg(String msg) {
		if(msg.startsWith("result::")) {
			handleResult(msg.substring("result::".length()));
		}else {
			printMsg(msg);
		}
	}
	
	private void handleResult(String msg) {
		System.out.println(msg);
		Result result = gson.fromJson(msg, Result.class);
		if("true".equals(result.getSuccess())) {
			if("getNickName".equals(result.getFunction()))
				setNickName(result.getData());
			else if("setNickName".equals(result.getFunction()))
				setNickName(result.getData());
		}
			
	}
	
	private static void postMsg(String msg) {
		if(reader != null && pw != null) {
			try{
				pw.println(msg==null?"":msg);
				pw.flush();
			}catch(Exception e) {
			}
		}
	}
	
	private static void send() {
		String msg = textField.getText();
		textField.setText("");
		postMsg(msg);
	}
}

class Params {
	private String function;
	private String para;
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	
	
}

class Result {
	private String success;
	private String data;
	private String function;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getFunction() {
		return function;
	}
	
	public void setFunction(String function) {
		this.function = function;
	}
}
