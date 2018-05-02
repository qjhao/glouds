package sin.glouds.project.jdao.util;

public class StringUtil {
	public static String convertFromSqlToBean(String words) {
		char[] cs = words.trim().replaceAll("_", " ").toLowerCase().toCharArray();
		for(int i = 0; i < cs.length; i++) {
			if(cs[i] == ' ') {
				cs[i + 1] = (char)(cs[i + 1] - 32);
			}
		}
		return new String(cs).replaceAll(" ", "");
	}
	
	public static String convertFromBeanToSql(String words) {
		words = words.trim();
		for(int i = 0; i < words.length(); i++) {
			char ch = words.charAt(i);
			if((int)ch > 'A' - 1 && (int)ch < 'Z' + 1) {
				words = words.replace(ch + "", "_" + (char)(ch + 32));
			}
		}
		return words;
	}
	
	public static String convertFromBeanToSqlTable(String words) {
		words = words.trim();
		for(int i = 0; i < words.length(); i++) {
			char ch = words.charAt(i);
			if((int)ch > 'A' - 1 && (int)ch < 'Z' + 1) {
				words = words.replace(ch + "", "_" + (char)(ch + 32));
			}
		}
		if(words.startsWith("_"))
			words = words.substring(1);
		return words;
	}
	
	public static String toFirstUpperCase(String name) {
		if(name.length() == 1)
			return name.toUpperCase();
		char firstChar = name.charAt(0);
		name = name.replace(firstChar, Character.toUpperCase(firstChar));
		return name;
	}
	
	public static String toFirstLowerCase(String name) {
		if(name.length() == 1)
			return name.toLowerCase();
		char firstChar = name.charAt(0);
		name = name.replace(firstChar, Character.toLowerCase(firstChar));
		return name;
	}
	
	public static void main(String[] args) {
		System.out.println(convertFromBeanToSql("chenYunBB"));
		System.out.println(convertFromSqlToBean("chen_yun_b_b"));
	}
}
