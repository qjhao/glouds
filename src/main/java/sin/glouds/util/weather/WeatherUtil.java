package sin.glouds.util.weather;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import org.springframework.util.Assert;

public class WeatherUtil {

	// 传说中的坑爹玩意儿
	// private static String addr1 =
	// "http://www.weather.com.cn/data/sk/101010100.html";
	// private static String addr2 =
	// "http://www.weather.com.cn/data/cityinfo/101010100.html";
	// private static String addr3 =
	// "http://m.weather.com.cn/data/101010100.html";

	// mmp 到底是WHAT编码？@！！！
	// rlgl 还要压缩 要上天啊！！！
	// http://wthrcdn.etouch.cn/weather_mini?city=北京
	// 通过城市名字获得天气数据，json数据
	// http://wthrcdn.etouch.cn/weather_mini?citykey=101010100

	// 目瞪狗呆 都TM压缩了
	// http://wthrcdn.etouch.cn/WeatherApi?citykey=101010100
	// 通过城市id获得天气数据，xml文件数据,
	// 当错误时会有<error>节点
	// http://wthrcdn.etouch.cn/WeatherApi?city=北京
	// 通过城市名字获得天气数据，xml文件数据

	public static void main(String[] args) throws IOException {
		System.out.println(getWeatherXmlByCode("101120502"));
	}

	public static String getWeatherXmlByCode(String code) throws IOException {
		Assert.hasText(code, "城市代码不能为空");
		URL url = new URL("http://wthrcdn.etouch.cn/WeatherApi?citykey=" + code);
		URLConnection connection = url.openConnection();

		InputStream is;
		BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		bis.mark(2);
		byte[] header = new byte[2];
		int result = bis.read(header);
		bis.reset();
		// Judge header
		int headerData = (int) ((header[0] << 8) | header[1] & 0xFF);
		if (result != -1 && headerData == 0x1f8b) {
			is = new GZIPInputStream(bis);
		} else {
			is = bis;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String xml = "";
		String line = null;
		while ((line = br.readLine()) != null) {
			xml += line;
		}
		br.close();
		return xml;
	}
	
	public static String getWeatherXmlByName(String name) throws IOException {
		Assert.hasText(name, "城市名不能为空");
		URL url = new URL("http://wthrcdn.etouch.cn/WeatherApi?city=" + name);
		URLConnection connection = url.openConnection();

		InputStream is;
		BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		bis.mark(2);
		byte[] header = new byte[2];
		int result = bis.read(header);
		bis.reset();
		// Judge header
		int headerData = (int) ((header[0] << 8) | header[1] & 0xFF);
		if (result != -1 && headerData == 0x1f8b) {
			is = new GZIPInputStream(bis);
		} else {
			is = bis;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String xml = "";
		String line = null;
		while ((line = br.readLine()) != null) {
			xml += line;
		}
		br.close();
		return xml;
	}
	
	public static InputStream getWeatherStreamByName(String name) throws IOException {
		Assert.hasText(name, "城市名不能为空");
		URL url = new URL("http://wthrcdn.etouch.cn/WeatherApi?city=" + name);
		URLConnection connection = url.openConnection();

		InputStream is;
		BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		bis.mark(2);
		byte[] header = new byte[2];
		int result = bis.read(header);
		bis.reset();
		// Judge header
		int headerData = (int) ((header[0] << 8) | header[1] & 0xFF);
		if (result != -1 && headerData == 0x1f8b) {
			is = new GZIPInputStream(bis);
		} else {
			is = bis;
		}

		return is;
	}
	
	public static String getWeatherJsonByCode(String code) throws IOException {
		Assert.hasText(code, "城市代码不能为空");
		URL url = new URL("http://wthrcdn.etouch.cn/weather_mini?citykey=" + code);
		URLConnection connection = url.openConnection();

		InputStream is;
		BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		bis.mark(2);
		byte[] header = new byte[2];
		int result = bis.read(header);
		bis.reset();
		// Judge header
		int headerData = (int) ((header[0] << 8) | header[1] & 0xFF);
		if (result != -1 && headerData == 0x1f8b) {
			is = new GZIPInputStream(bis);
		} else {
			is = bis;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String json = "";
		String line = null;
		while ((line = br.readLine()) != null) {
			json += line;
		}
		br.close();
		return json;
	}
	
	public static String getWeatherJsonByName(String name) throws IOException {
		Assert.hasText(name, "城市名不能为空");
		URL url = new URL("http://wthrcdn.etouch.cn/weather_mini?city=" + name);
		URLConnection connection = url.openConnection();

		InputStream is;
		BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		bis.mark(2);
		byte[] header = new byte[2];
		int result = bis.read(header);
		bis.reset();
		// Judge header
		int headerData = (int) ((header[0] << 8) | header[1] & 0xFF);
		if (result != -1 && headerData == 0x1f8b) {
			is = new GZIPInputStream(bis);
		} else {
			is = bis;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String json = "";
		String line = null;
		while ((line = br.readLine()) != null) {
			json += line;
		}
		br.close();
		return json;
	}
}
