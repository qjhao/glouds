package sin.glouds.temp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class YouxTest {

	public static void main(String[] args) throws IOException {
		String cookie = "; ; ; ; ; MainPage_Id=; MainPage_Url=; ; ; ; ; ; ; ; ";
		Map<String, String> map = new HashMap<>();
		map.put("ASP.NET_SessionId", "l0cobn32y1jzvtypfxlwoire");
		map.put("IESESSION", "alive");
		map.put("_qddaz", "QD.aaaqhd.hzby7u.jiv4wghq");
		map.put("pgv_pvi", "8404189184");
		map.put("pgv_si", "s4358292480");
		map.put("_qddamta_4000108598", "3-0");
		map.put("tencentSig", "5030336512");
		map.put("Account_Id", "%E4%BA%A7%E5%93%81%E9%83%A8");
		map.put("Account_Pwd","CDCB631915FECB038F323CF81F0F410D");
		map.put("Themes_Name","Office2003Blue");
		map.put("Account_BUS_ID","001015006007J015B005");
		map.put("Distr_Id","001015006007J015");
		map.put("Distr_NAME","%e4%ba%a7%e5%93%81%e9%83%a8%e5%95%86%e8%b4%b8%e5%85%ac%e5%8f%b8");
		map.put("Area_Id","001015006007");
		map.put("Area_NAME","%e9%ab%98%e5%af%86");
		map.put("Visual_Name","%e4%bc%a0%e7%bb%9f%e9%a3%8e%e6%a0%bc");
		map.put("Oper_Id","001015006007J015Y001");
		map.put("Business_ID","001015006007J015B005");
		map.put("Business_NAME","%e6%b5%b7%e5%a4%a9%e4%ba%8b%e4%b8%9a%e9%83%a8");
		map.put("Expires","2018-06-27 12:42:56");
		map.put("_qddab","3-a9b5at.jiv6tb5a");
		map.put("_qdda","3-1.1");
		map.put("BrowserHeight","759");
		Document document = Jsoup.connect("http://test.xaoke.cn/Home.aspx").cookies(map).get();
		document.getElementsByTag("script").forEach(obj -> {
			System.out.println("==================================");
			System.out.println(obj.attr("src"));
			System.out.println("");
		});
	}
}
