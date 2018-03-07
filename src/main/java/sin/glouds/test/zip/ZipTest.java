package sin.glouds.test.zip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

import static sin.glouds.util.staticutil.UIManagerUtil.*;

@SuppressWarnings("serial")
public class ZipTest extends JFrame {

	@SuppressWarnings("unused")
	private static String filePath = "C://hjb/sins/out/zip/bef";
	private static String outFilePath = "C://hjb/sins/out/zip/aft";
	private static InputStream input;
	private static ZipOutputStream output;
	
	public static void main(String[] args) throws Exception {
		//compress(filePath + "bef", filePath + "aft/1.zip");
		//compress(filePath + "bef", filePath + "aft/4.zip");
		
		defaultUIManager();
		
		new ZipTest();
		//compress(new File[]{new File(filePath)});
	}
	
	public ZipTest() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSystemView(FileSystemView.getFileSystemView());
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setMultiSelectionEnabled(true);
		chooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = (JFileChooser)e.getSource();
				File[] files = fileChooser.getSelectedFiles();
				try {
					//compress(files);
					compress(files[0], files[0].getName());
				} catch (ZipException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(chooser);
		setBounds(100,100,500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void compress(File file, String zipFileName) throws ZipException, IOException {
		File zipFile = new File(zipFileName);
		if(!file.exists()) {
			System.out.println("要压缩的文件不存在");
			return;
		}
		InputStream input = null;
		ZipOutputStream output = new ZipOutputStream(new FileOutputStream(zipFile));
		if(file.isDirectory()) {
			for(File file2 : file.listFiles()) {
				if(file2.isFile()) {
					byte[] bs = new byte[1024];
					input = new FileInputStream(file2);
					output.putNextEntry(new ZipEntry(file2.getName()));
					while(input.read(bs) != -1) {
						output.write(bs);
					}
				}else if(file2.isDirectory()) {
					for(File file3 : file2.listFiles()) {
						byte[] bs = new byte[1024];
						input = new FileInputStream(file3);
						output.putNextEntry(new ZipEntry(new ZipEntry(file2.getName() + "/" + file3.getName())));
						while(input.read(bs) != -1) {
							output.write(bs);
						}
					}
				}
			}
		}else if(file.isFile()) {
			byte[] bs = new byte[1024];
			input = new FileInputStream(file);
			output.putNextEntry(new ZipEntry(file.getName()));
			while(input.read(bs) != -1) {
				output.write(bs);
			}
		}
		if(input != null)
			input.close();
		if(output != null)
			output.close();
		System.out.println("==");
	}
	
	public static void compress(File[] files) throws IOException,ZipException {
		String zipFileName = "";
		if(files.length == 0) {
			
		}else if(files.length == 1) {
			zipFileName = files[0].getName();
		}else {
			zipFileName = files[0].getParentFile().getName();
		}
		
		File zipFile = new File(outFilePath, zipFileName + ".zip");
		System.out.println(zipFile.getAbsolutePath());
		input = null;
		output = new ZipOutputStream(new FileOutputStream(zipFile));
		
		if(files.length == 1) {
			File file = files[0];
			
			if(!file.exists()) {
				System.out.println("要压缩的文件不存在");
				return;
			}
			comp(file, file.getName());
		}else {
			for(File file : files) {
				
				if(!file.exists()) {
					System.out.println("要压缩的文件不存在");
					continue;
				}
				
				comp(file, file.getName());
			}
		}
		
		output.flush();
		
		if(input != null)
			input.close();
		if(output != null)
			output.close();
	}
	
	public static void compresss(File file, String zipFileName) throws IOException {
		File zipFile = new File(zipFileName);
		
		if(!file.exists()) {
			System.out.println("要压缩的文件不存在");
			return;
		}
		input = null;
		output = new ZipOutputStream(new FileOutputStream(zipFile));
		
		comp(file, file.getName());
		
		if(input != null)
			input.close();
		if(output != null)
			output.close();
	}
	
	private static void comp(File file, String path) throws IOException {
		System.out.println(path);
		if(file.isDirectory()) {
			for(File file2 : file.listFiles()) {
				comp(file2, path + "/" + file2.getName());
			}
		}else if(file.isFile()) {
			byte[] bs = new byte[1024];
			input = new FileInputStream(file);
			output.putNextEntry(new ZipEntry(path));
			while(input.read(bs) != -1) {
				output.write(bs);
			}
		}
	}
}
