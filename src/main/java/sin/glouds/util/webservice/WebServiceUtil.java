package sin.glouds.util.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sin.glouds.common.Global;

public class WebServiceUtil {

	/**
	 * 生成WebService客户端代码
	 * 
	 * @param url
	 *            WebService请求地址
	 * @param dir
	 *            生成代码的保存地址
	 * @return 生成信息
	 * @author JohnSin
	 */
	public static String generateClientCode(String url, String dir) {
		return generateClientCode(url, dir, "");
	}

	/**
	 * 生成WebService客户端代码
	 * 
	 * @param url
	 *            WebService请求地址
	 * @param dir
	 *            生成代码的保存地址
	 * @param pkg
	 *            生成代码保存的包名
	 * @return 生成信息
	 * @author JohnSin
	 */
	public static String generateClientCode(String url, String dir, String pkg) {
		if (url == null || "".equals(url))
			return "url 不能为空";
		if (dir == null || "".equals(dir))
			return "dir 生成代码存放目录不能为空";
		if(!url.startsWith("http"))
			url = "http://" + url;
		if(!url.endsWith("?wsdl"))
			url = url + "?wsdl";
		return generateClientCode(url, dir, pkg, Global.getSystemProp("sun.jnu.encoding"));
	}

	/**
	 * 生成WebService客户端代码
	 * 
	 * @param url
	 *            WebService请求地址
	 * @param dir
	 *            生成代码的保存地址
	 * @param pkg
	 *            生成代码保存的包名
	 * @param charset
	 *            操作系统字符集
	 * @return 生成信息
	 * @author JohnSin
	 */
	private static String generateClientCode(String url, String dir, String pkg, String charset) {
		try {
			String commond = "wsimport -s " + dir + " -keep " + url;
			if (pkg != null && !"".equals(pkg.trim()))
				commond = "wsimport -s " + dir + " -keep " + url + " -p " + pkg;
			Process process = Runtime.getRuntime().exec(commond);
			String line = null;
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), charset));
			while ((line = reader.readLine()) != null) {
				if ("".equals(line.trim())) {
					sb.append(line);
				} else {
					sb.append(line);
					sb.append("\n");
				}
			}
			return sb.toString();
		} catch (IOException e) {
			return e.getMessage();
		}
	}

	/**
	 * 校验生成客户端返回字符串，判断是否生成成功
	 * 
	 * @param result 生成客户端所返回的字符串
	 * @return 
	 * @author JohnSin
	 */
	public static boolean checkGenerate(String result) {
		if (result == null || "".equals(result))
			return false;
		if (result.contains("正在解析") && result.contains("正在生成") && result.contains("正在编译"))
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		String result = generateClientCode("http://localhost:8080/yige/webservice/service?wsdl",
				"F://temp/WebServiceTest", "com.yige");
		System.out.println(checkGenerate(result));
		System.out.println(result);
	}
}
