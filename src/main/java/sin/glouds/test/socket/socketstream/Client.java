package sin.glouds.test.socket.socketstream;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sin.glouds.util.transforstream.TransferStreamUtil;

@SuppressWarnings("serial")
public class Client extends JFrame {

	private JTextField fileName = new JTextField(),
			dir = new JTextField();
	private JButton open = new JButton("Open"),
			save = new JButton("Save");
	public Client() {
		JPanel p = new JPanel();
		open.addActionListener(new OpenL());
		p.add(open);
		save.addActionListener(new SaveL());
		p.add(save);
		add(p, BorderLayout.SOUTH);
		dir.setEditable(false);
		fileName.setEditable(false);
		p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		p.add(fileName);
		p.add(dir);
		add(p, BorderLayout.NORTH);
	}
	
	class OpenL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			int rVal = c.showOpenDialog(Client.this);
			if(rVal == JFileChooser.APPROVE_OPTION) {
				fileName.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if(rVal == JFileChooser.CANCEL_OPTION) {
				fileName.setText("You pressed cancel");
				dir.setText("");
			}
		}
		
	}
	
	class SaveL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			int rVal = c.showSaveDialog(Client.this);
			if(rVal == JFileChooser.APPROVE_OPTION) {
				fileName.setText(c.getSelectedFile().getName());;
				dir.setText(c.getCurrentDirectory().toString());;
				pushFile(c.getSelectedFile());
			}
			if(rVal == JFileChooser.CANCEL_OPTION) {
				fileName.setText("You pressed cancel");
				dir.setText("");
			}
		}
		
	}
	
	public static void pushFile(File file) {
		try {
			Socket socket = new Socket("localhost", 9999);
//			PrintWriter writer = new PrintWriter(socket.getOutputStream());
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String line;
//			while((line = reader.readLine()) != null) {
//				writer.println(line);
//			}
//			writer.flush();
//			reader.close();
//			writer.close();
			TransferStreamUtil.transfer(new FileReader(file), socket.getOutputStream());
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//run(new FileChooserTest(), 250, 150);
		pushFile(new File("F:/wcc.txt"));
	}
}
