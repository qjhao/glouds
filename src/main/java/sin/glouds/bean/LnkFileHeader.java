package sin.glouds.bean;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class LnkFileHeader {
	public byte[] fixL = new byte[4];
	public byte[] guid = new byte[16];
	public byte[] flags = new byte[4];
	public byte[] targetFileProp = new byte[4];
	public byte[] createTime = new byte[8];
	public byte[] modifyTime = new byte[8];
	public byte[] lastVisitTime = new byte[8];
	public byte[] targetFileLength = new byte[4];
	public byte[] defIconNum = new byte[4];
	public byte[] targetWindowShowType = new byte[4];
	public byte[] hotKey = new byte[4];
	public byte[] unknow = new byte[8];
	
	public LnkFileHeader(RandomAccessFile raf) throws IOException {
		raf.read(fixL);
		raf.read(guid);
		raf.read(flags);
		raf.read(targetFileProp);
		raf.read(createTime);
		raf.read(modifyTime);
		raf.read(lastVisitTime);
		raf.read(targetFileLength);
		raf.read(defIconNum);
		raf.read(targetWindowShowType);
		raf.read(hotKey);
		raf.read(unknow);
	}

	@Override
	public String toString() {
		return "LnkFileHeader [fixL=" + Arrays.toString(fixL) + ", guid=" + Arrays.toString(guid) + ", flags="
				+ Arrays.toString(flags) + ", targetFileProp=" + Arrays.toString(targetFileProp) + ", createTime="
				+ Arrays.toString(createTime) + ", modifyTime=" + Arrays.toString(modifyTime) + ", lastVisitTime="
				+ Arrays.toString(lastVisitTime) + ", targetFileLength=" + Arrays.toString(targetFileLength)
				+ ", defIconNum=" + Arrays.toString(defIconNum) + ", targetWindowShowType="
				+ Arrays.toString(targetWindowShowType) + ", hotKey=" + Arrays.toString(hotKey) + ", unknow="
				+ Arrays.toString(unknow) + "]";
	}
	
	
}
