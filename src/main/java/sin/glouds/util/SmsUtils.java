package sin.glouds.util;

public class SmsUtils {

	public static boolean sendSms(String receiver, String content) {
		try{
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
