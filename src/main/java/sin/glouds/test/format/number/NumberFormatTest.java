package sin.glouds.test.format.number;

import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class NumberFormatTest {

	public static void main(String[] args) {
		//format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
		//format(Locale.FRANCE, "e = %+10.4f", Math.PI);
		//format("$ %(,.2f", 6217.588);
		format("Local time: %tT", new Date());
	}
	
	public static String format(String str, Object ... objs) {
		Formatter formatter = new Formatter();
		String result = formatter.format(str, objs).toString();
		formatter.close();
		System.out.println(result);
		return result;
	}
	
	public static String format(Locale locale, String str, Object ... objs) {
		Formatter formatter = new Formatter();
		String result = formatter.format(locale, str, objs).toString();
		formatter.close();
		System.out.println(result);
		return result;
	}
}
