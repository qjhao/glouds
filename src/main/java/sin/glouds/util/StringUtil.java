package sin.glouds.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.StringUtils;

public class StringUtil extends StringUtils {
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str))
			return true;
		return false;
	}

	public static boolean isEmptyString(Object obj) {
		if (obj == null || "".equals(obj.toString()))
			return true;
		return false;
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static String[] betweenWith(String str, String begin, String end) {
		str.indexOf(begin);
		return null;
	}

	public static String toFirstUpperCase(String name) {
		if (name.length() == 1)
			return name.toUpperCase();
		String firstChar = name.substring(0, 1);
		name = name.replaceFirst(firstChar, firstChar.toUpperCase());
		return name;
	}

	public static String toFirstLowerCase(String name) {
		if (name.length() == 1)
			return name.toLowerCase();
		String firstChar = name.substring(0, 1);
		name = name.replaceFirst(firstChar, firstChar.toLowerCase());
		return name;
	}

	public static String tableNameToClassName(String tableName) {
		if (tableName.contains("_")) {
			String[] strs = tableName.split("_");
			String className = "";
			for (String str : strs) {
				className += toFirstUpperCase(str);
			}
			return className;
		} else {
			return toFirstUpperCase(tableName);
		}
	}

	public static String columnNameToFieldName(String columnName) {
		if (columnName.contains("_")) {
			String[] strs = columnName.split("_");
			String fieldName = "";
			for (String str : strs) {
				if (fieldName == "") {
					fieldName = str;
				} else {
					fieldName += toFirstUpperCase(str);
				}
			}
			return fieldName;
		} else {
			return columnName;
		}
	}

	public static boolean isNumber(String str) {
		if (isEmpty(str))
			return false;
		try {
			Double.valueOf(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String getStackTrace(Exception e) {
		StringWriter writer = new StringWriter();
		PrintWriter pw = new PrintWriter(writer);
		e.printStackTrace(pw);
		String result = writer.toString();
		pw.close();
		return result;
	}

	public static String formatJson(String jsonStr) {
		int level = 0;
		StringBuffer jsonForMatStr = new StringBuffer();
		for (int i = 0; i < jsonStr.length(); i++) {
			char c = jsonStr.charAt(i);
			if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
				jsonForMatStr.append(getLevelStr(level));
			}
			switch (c) {
			case '{':
			case '[':
				jsonForMatStr.append(c + "\n");
				level++;
				break;
			case ',':
				jsonForMatStr.append(c + "\n");
				break;
			case '}':
			case ']':
				jsonForMatStr.append("\n");
				level--;
				jsonForMatStr.append(getLevelStr(level));
				jsonForMatStr.append(c);
				break;
			default:
				jsonForMatStr.append(c);
				break;
			}
		}

		return jsonForMatStr.toString();

	}

	private static String getLevelStr(int level) {
		StringBuffer levelStr = new StringBuffer();
		for (int levelI = 0; levelI < level; levelI++) {
			levelStr.append("\t");
		}
		return levelStr.toString();
	}
}
