package sin.glouds.test.huatianoa;

import java.io.IOException;

import org.jsoup.Jsoup;

public class Test {

	private static String url = "http://123.206.34.218:8888/OAapp/WebObjects/OAapp.woa";
//	private static String login_url = "http://123.206.34.218:8888/OAapp/WebObjects/OAapp.woa/wo/com.oa8000.mainapp.Main/4N9BGgmAnrdwivE5YMSHvM/0.12;jsessionid=A20A8D23A76537DF037EDC3A1E835AB5";
	public static void main(String[] args) throws IOException {
//		Jsoup.connect(url).get().getElementsByTag("input").forEach(obj -> {
//			if(obj.hasAttr("type") && !obj.attr("type").equals("hidden")) {
//				System.out.println(obj.toString()+"\n\n");
//			}
//		});
//		Map<String, String> map = new HashMap<>();
//		map.put("userId", "qinjh");
//		map.put("userPwd", "123456");
//		map.put("12.17", "BLUE");
//		map.put("12.18", "CN");
		System.out.println(Jsoup.connect(url).data().get().html());
	}
}
