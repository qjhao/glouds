package sin.glouds.test.file.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjSari implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String desc;
	
	public static void main(String[] args) {
		
		read();
		
	}
	
	public static void read() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("E:\\oj.text")));
			ObjSari os = (ObjSari)ois.readObject();
			System.out.println(os.name+" :"+os.desc);
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void write() {
		try {
			ObjSari objSari = new ObjSari();
			objSari.name = "johnsin";
			objSari.desc = "aaa";
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("E:\\oj.text")));
			objectOutputStream.writeObject(objSari);
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
