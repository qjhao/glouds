package sin.glouds.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServiceUtil {
	private static final Logger logger = LoggerFactory.getLogger(WebServiceUtil.class);

	public static String connectEPort(String wsdl, final byte[] sendJson) {
		String returnXml = null;
		if (sendJson != null && sendJson.length > 0) {
			InputStreamReader isr = null;
			BufferedReader br = null;
			OutputStream output = null;
			HttpURLConnection conn = null;
			try {
				// URL连接
				URL url = new URL(wsdl);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept-Charset", "UTF-8");
				conn.setRequestProperty("Content-Length", String.valueOf(sendJson.length));
				//conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setConnectTimeout(5000);
				// 请求输入内容
				output = conn.getOutputStream();
				output.write(sendJson);
				output.flush();
				InputStream inputStream = conn.getInputStream();
				// 真实电子口岸推送应该是没有返回信息的
				if (inputStream != null) {
					// 请求返回内容
					isr = new InputStreamReader(inputStream, "UTF-8");
					br = new BufferedReader(isr);
					StringBuilder sb = new StringBuilder();
					String str = null;
					while ((str = br.readLine()) != null) {
						sb.append(str + "\n");
					}
					returnXml = sb.toString();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				returnXml = null;
				logger.info(e1.toString() + "请求电子口岸订单推送webservice接口失败");
			} finally {
				try {
					if (br != null) {
						br.close();
					}
					if (isr != null) {
						isr.close();
					}
					if (output != null) {
						output.close();
					}
					if (conn != null) {
						conn.disconnect();
					}
				} catch (IOException e) {
					e.printStackTrace();
					logger.info(e.toString() + "流关闭失败！");
				}
			}
		}
		return returnXml;
	}

}
