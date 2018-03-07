package sin.deskapp.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.google.gson.Gson;

import sin.deskapp.bean.Params;
import sin.deskapp.socket.ClientSocket;

public class ChatPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4061397906568411746L;

	public ChatPanel() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		pane = new JScrollPane(textArea);
		this.add(pane);
		JPanel jPanel = new JPanel();
		textField = new JTextField(12);
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
		setSize(250, 300);
		setLocation(50, 100);
		setVisible(true);
		getNickName();
	}
	
	private Gson gson = new Gson();
	
	private void getNickName() {
		if(ClientSocket.startClient())
			return;
		Params params = new Params();
		params.setFunction("getNickName");
		params.setPara("");
		String json = gson.toJson(params);
		String msg = "command::" + json;
		ClientSocket.postMsg(msg);
	}
	
	private static JTextArea textArea;
	private static JTextField textField;
	private static JScrollPane pane;
	
	private static void send() {
		String msg = textField.getText();
		textField.setText("");
		ClientSocket.postMsg(msg);
	}
}
