package sin.glouds.bean;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class Header {
	public LnkFileHeader lnkFileHeader;
	public String fixL;
	public String guid;
	public boolean[] flags;
	public String targetFileProp;
	public Date createTime;
	public Date modifyTime;
	public Date lastVisitTime;
	public int targetFileLength;
	public int defIconNum;
	public String targetWindowShowType;
	public String hotKey;
	public String unknow;
	
	public Header(LnkFileHeader lnkFileHeader) throws UnsupportedEncodingException, ParseException {
		this(lnkFileHeader, "UTF-8");
	}
	
	public Header(LnkFileHeader lnkFileHeader, String code) throws UnsupportedEncodingException, ParseException {
		this.lnkFileHeader = lnkFileHeader;
		this.fixL = new String(lnkFileHeader.fixL, code);
		this.guid = new String(lnkFileHeader.guid, code);
		this.flags = parseFlags(lnkFileHeader.flags);
		this.targetFileProp = new String(lnkFileHeader.targetFileProp, code);
//		this.createTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(new String(lnkFileHeader.createTime, code));
//		this.modifyTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(new String(lnkFileHeader.modifyTime, code));
//		this.lastVisitTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(new String(lnkFileHeader.lastVisitTime, code));
//		this.targetFileLength = Integer.parseInt(new String(lnkFileHeader.targetFileLength, code));
//		this.defIconNum = Integer.parseInt(new String(lnkFileHeader.defIconNum, code));
//		this.targetWindowShowType = new String(lnkFileHeader.targetWindowShowType, code);
//		this.hotKey = new String(lnkFileHeader.hotKey, code);
//		this.unknow = new String(lnkFileHeader.unknow, code);
	}
	
	private boolean[] parseFlags(byte[] flags) {
		boolean[] result = new boolean[32];
		if(flags.length == 4) {
			for(int i = 0;i < 8;i++) {
				result[i] = (flags[0] >> (8-i) & 1) == 1;
			}
			for(int i = 0;i < 8;i++) {
				result[i+8] = (flags[1] >> (8-i) & 1) == 1;
			}
			for(int i = 0;i < 8;i++) {
				result[i+16] = (flags[2] >> (8-i) & 1) == 1;
			}
			for(int i = 0;i < 8;i++) {
				result[i+24] = (flags[3] >> (8-i) & 1) == 1;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Header [fixL=" + fixL + ", guid=" + guid + ", flags="
				+ Arrays.toString(flags) + ", targetFileProp=" + targetFileProp + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", lastVisitTime=" + lastVisitTime + ", targetFileLength="
				+ targetFileLength + ", defIconNum=" + defIconNum + ", targetWindowShowType=" + targetWindowShowType
				+ ", hotKey=" + hotKey + ", unknow=" + unknow + "]";
	}
	
	
}
