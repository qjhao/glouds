package sin.glouds.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FileCheckUtil {
	public static void main(String[] args) {
//		File file = new File("out");
//		System.out.println(file.exists());
//		System.out.println(saveFileInfo(file));
//		System.out.println(checkFiles(file));
		
//		System.out.println();
	}
	
	private static final String path = "out/filecheck/";
	private static final String suffix = ".txt";
	
	static {
		String[] dirs = path.split("/");
		String parent = "";
		for(String dir : dirs) {
			parent = parent + dir;
			File file = new File(parent);
			if(!file.exists())
				file.mkdirs();
			parent = parent + "/";
		}
	}
	
	public static boolean checkFiles(File file) {
		FileInfo oldFileInfo = readFileInfo(file),
				newFileInfo = getFileInfo(file);
		return compareFileInfos(oldFileInfo, newFileInfo);
	}
	
	private static boolean compareFileInfos(FileInfo oldFileInfo, FileInfo newFileInfo) {
		if(oldFileInfo.getIsDirectory() != newFileInfo.getIsDirectory())
			return false;
		if(!oldFileInfo.getName().equals(newFileInfo.getName()))
			return false;
		if(!oldFileInfo.getPath().equals(newFileInfo.getPath()))
			return false;
//		判断条件过于严格		
//		if(oldFileInfo.getSize() != newFileInfo.getSize())
//			return false;
		if(((oldFileInfo.getFileInfos() != null && newFileInfo.getFileInfos() != null) && oldFileInfo.getFileInfos().size() != newFileInfo.getFileInfos().size()) || ((oldFileInfo.getFileInfos() == null) != (newFileInfo.getFileInfos() == null)))
			return false;
		if(newFileInfo.getFileInfos() != null && oldFileInfo.getFileInfos() != null) {
			for(int i = 0; i < oldFileInfo.getFileInfos().size(); i++) {
				if(!compareFileInfos(oldFileInfo.getFileInfos().get(i), newFileInfo.getFileInfos().get(i)))
					return false;
			}
		}
		return true;
	}

	private static FileInfo readFileInfo(File file) {
		File file2 = new File(path + file.getName() + suffix);
		if(!file2.exists())
			return getFileInfo(file);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2))) {
			return (FileInfo)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return getFileInfo(file);
		}
	}
	
	public static boolean saveFileInfo(File file) {
		FileInfo fileInfo = getFileInfo(file);
		if(fileInfo == null)
			return false;
		return saveFileInfo(file, fileInfo);
	}
	
	private static boolean saveFileInfo(File file, FileInfo fileInfo) {
		try {
			File file2 = new File(path + file.getName() + suffix);
			if(!file2.exists())
				file2.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2));
			oos.writeObject(fileInfo);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private static FileInfo getFileInfo(File file) {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setIsDirectory(file.isDirectory());
		fileInfo.setName(file.getName());
		fileInfo.setPath(file.getPath());
		fileInfo.setSize(file.length());
		if(file.isDirectory()) {
			List<FileInfo> fileInfos2 = new ArrayList<>();
			for(File file2 : file.listFiles()) {
				fileInfos2.add(getFileInfo(file2));
			}
			fileInfo.setFileInfos(fileInfos2);
		}
		return fileInfo;
	}
}
class FileInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean isDirectory;
	private Long size;
	private String name;
	private String path;
	private List<FileInfo> fileInfos;
	public Boolean getIsDirectory() {
		return isDirectory;
	}
	public void setIsDirectory(Boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<FileInfo> getFileInfos() {
		return fileInfos;
	}
	public void setFileInfos(List<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}
}