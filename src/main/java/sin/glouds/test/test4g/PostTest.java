package sin.glouds.test.test4g;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class PostTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		String xml = "format=xml&data=<logisticsEventsRequest><logisticsEvent><eventBody><logisticsDetail><orderNo>orderno</orderNo><logisticsCode>SUCCESS</logisticsCode><logisticsErrorImgUrl>c://hjb/1.jpg</logisticsErrorImgUrl></logisticsDetail><receiverDetail><city>上海市</city><district>浦东新区</district><name>储琼</name><province>上海市</province><streetAddress>上海市南汇区上海 上海市 南汇区 上海电力学院浦东校区</streetAddress><tel>17091269194 17091269194</tel></receiverDetail></eventBody><eventHeader><eventSource>Test</eventSource><eventTarget>XSCZ</eventTarget><eventTime>2016-05-18 14:08:40</eventTime></eventHeader></logisticsEvent></logisticsEventsRequest>";
		String str = "<logisticsEventsRequest><logisticsEvent><eventBody><logisticsDetail><orderNo>orderno</orderNo><logisticsCode>SUCCESS</logisticsCode><logisticsErrorImgUrl>c://hjb/1.jpg</logisticsErrorImgUrl></logisticsDetail><receiverDetail><city>上海市</city><district>浦东新区</district><name>储琼</name><province>上海市</province><streetAddress>上海市南汇区上海 上海市 南汇区 上海电力学院浦东校区</streetAddress><tel>17091269194 17091269194</tel></receiverDetail></eventBody><eventHeader><eventSource>Test</eventSource><eventTarget>XSCZ</eventTarget><eventTime>2016-05-18 14:08:40</eventTime></eventHeader></logisticsEvent></logisticsEventsRequest>";
		
		URL url = new URL("http://localhost:8080/directMail/receiveMsg/GoodsArrival");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.getOutputStream().write(xml.getBytes());
		connection.getOutputStream().flush();
		System.out.println(URLEncoder.encode(str));
	}
}
