package test.haier.msg;

import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import sin.glouds.util.StringUtil;

public class MessageOperate {

	private static String baseUrl = "http://111.204.226.241:7061/Status_drag.php";
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	public static String encryptMD5(String key) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			md5.update(key.getBytes());
			return bytesToHexStr(md5.digest());
		}catch(Exception e) {
			return "";
		}
	}
	
	private static String bytesToHexStr(byte[] md) {
		char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
		int j = md.length;
		char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
	}
	
	public List<MessageReceive> operate(String msg) {
		System.out.println(msg);
		List<MessageReceive> receives = new ArrayList<>();
		if(StringUtil.isEmpty(msg)) {
			String[] strs = msg.split("||");
			for(String str : strs) {
				String[] ss = str.split(",");
				if(ss.length == 5) {
					MessageReceive receive = new MessageReceive(ss[1], ss[0], ss[2], ss[3], ss[4]);
					receives.add(receive);
				}else {
					//打印日志
					System.out.println(str);
				}
			}
		}
		return receives;
	}
	
	public static void main(String[] args) throws ParseException, IOException {
		MessageOperate operate = new MessageOperate();
		operate.operate(operate.httpRequest());
	}
	
	public String httpRequest() throws ParseException, IOException {
		String url = createUrl(baseUrl);
		HttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		HttpResponse response = client.execute(get);
		if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			return "请求失败";
		}else {
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(StringUtil.isEmpty(result)?"返回数据为空":result);
			return result;
		}
	}
	
	private String createUrl(String baseUrl) {
		StringBuilder sb = new StringBuilder(baseUrl);
		sb.append("?").append("epid=").append("123487")
		.append("&username=").append("hezx3")
		.append("&password=").append(encryptMD5("Hezx35841"))
		.append("&stime=").append(sdf.format(new Date()));
		return sb.toString();
	}
}
