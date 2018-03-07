package sin.glouds.util;

import java.text.SimpleDateFormat;

public class DateUtils {
	public static SimpleDateFormat getDateFormat(String pattern) {
		return new SimpleDateFormat(pattern);
	}
	
	public static SimpleDateFormat getDefaultDateFormat() {
		return getDateFormat(getPattern(TYPE_SIMPLE, true));
	}
	
	public static SimpleDateFormat getDateFormat(int type) {
		return getDateFormat(type, true);
	}
	
	public static SimpleDateFormat getDateFormat(int type, boolean isSeparator) {
		return getDateFormat(getPattern(type, isSeparator));
	}
	
	private static String fstSeparator = "-";
	private static String sndSeparator = ":";
	
	/**
	 * such as yyyy-MM-dd HH:mm:ss
	 */
	public static final int TYPE_SIMPLE = 1;
	/**
	 * such as yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static final int TYPE_LONG = 2;
	/**
	 * such as yyyy-MM-dd
	 */
	public static final int TYPE_SHORT = 3;
	
	private static String getPattern(int type, boolean isSeparator) {
		switch (type) {
		case TYPE_SIMPLE:
			if(isSeparator)
				return "yyyy" + fstSeparator + "MM" + fstSeparator + "dd" + " " + "HH" + sndSeparator + "mm" + sndSeparator + "ss";
			return "yyyyMMddHHmmss";
		case TYPE_SHORT:
			if(isSeparator)
				return "yyyy" + fstSeparator + "MM" + fstSeparator + "dd";
			return "yyyyMMdd";
		case TYPE_LONG:
			if(isSeparator)
				return "yyyy" + fstSeparator + "MM" + fstSeparator + "dd" + " " + "HH" + sndSeparator + "mm" + sndSeparator + "ss" + sndSeparator + "SSS";
			return "yyyyMMddHHmmssSSS";
		default:
			return "yyyy-MM-dd HH:mm:ss";
		}
	}
	
	public static void setYmdSeparator(String sep) {
		fstSeparator = sep;
	}
	
	public static void setHmsSeparator(String sep) {
		sndSeparator = sep;
	}
}
