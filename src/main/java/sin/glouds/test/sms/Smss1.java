package sin.glouds.test.sms;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Smss1 {
	public static void main(String[] args) {
		int result = 0;  
		String path = null;  
		JFileChooser fileChooser = new JFileChooser();  
		FileSystemView fsv = FileSystemView.getFileSystemView();  //ע���ˣ�������Ҫ��һ��  
		System.out.println(fsv.getHomeDirectory());                //�õ�����·��  
		fileChooser.setCurrentDirectory(fsv.getHomeDirectory());  
		fileChooser.setDialogTitle("��ѡ��Ҫ�ϴ����ļ�...");  
		fileChooser.setApproveButtonText("ȷ��");  
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
		result = fileChooser.showOpenDialog(null);  
		if (JFileChooser.APPROVE_OPTION == result) {  
		    path=fileChooser.getSelectedFile().getPath();  
		    System.out.println("path: "+path);  
		} 
	}
}
