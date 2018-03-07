package sin.glouds.util;

public final class BytesUtil {
	
	private BytesUtil() {
		
	}
	
	public static short bytesToShort(byte[] bytes, int offset) {
		if(offset < 0 || offset > bytes.length - 2)
			throw new ClassCastException("offset is not support to get a short.");
		return (short)(bytes[offset] | (bytes[offset + 1] << 8));
	}
	
	public static int bytesToInt(byte[] bytes, int offset) {
		if(offset < 0 || offset > bytes.length - 4)
			throw new ClassCastException("offset is not support to get a integer.");
		return (int)(bytes[offset] | (bytes[offset + 1] << 8) | (bytes[offset + 2] << 16) | (bytes[offset + 3] << 24));
	}
	
	public static short bytesToFloat(byte[] bytes, int offset) {
		if(offset < 0 || offset > bytes.length - 2)
			throw new ClassCastException("offset is not support to get a short.");
		return (short)(bytes[offset] | (bytes[offset + 1] << 8));
	}
	
	public static char[] bytesToChars(byte[] bytes, int offset, int length) {
		if(bytes == null)
			throw new IllegalArgumentException("bytes can not be null");
		if(offset < 0 || offset + length > bytes.length || length / 2 != 0)
			throw new IllegalArgumentException("illegal bytes,offset or length");
		char[] chars = new char[length/2];
		
		for(int i = 0; i < chars.length; i++) {
			chars[i] = (char)(bytes[offset + 2 * i] | (bytes[offset + 2 * i +1]));
		}
		return chars;
	}
	
	public static char bytesToChar(byte[] bytes, int offset) {
		if(offset < 0 || offset > bytes.length - 2)
			throw new ClassCastException("offset is not support to get a character.");
		return (char)(bytes[offset] | (bytes[offset + 1] << 8));
	}
	
	public static String bytesToString(byte[] bytes) {
		if(bytes == null)
			return "";
		if(bytes.length / 2 != 0)
			throw new ClassCastException("this bytes can not be cast to be a string.");
		char[] chars = bytesToChars(bytes, 0, bytes.length);
		return new String(chars);
	}
}
