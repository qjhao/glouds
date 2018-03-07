package sin.glouds.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void write(HttpServletResponse response, String as_Msg) {
		write(response, as_Msg, "text/html", "UTF-8");
	}

	public static void write(HttpServletResponse response, String as_Msg, String as_ContentType, String as_Charset) {
		as_ContentType = as_ContentType.trim();
		if (as_ContentType.length() == 0)
			as_ContentType = "text/html";
		as_Charset = as_Charset.trim();
		if (as_Charset.length() == 0)
			as_Charset = "UTF-8";

		response.setContentType(as_ContentType + "; charset=" + as_Charset);
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(as_Msg);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}

	public static String getUrl(HttpServletRequest request) {
		if (request == null) {
			printMsg("getUrl()", "request is null");
			return null;
		}

		String url = "";
		if (request.getAttribute("javax.servlet.forward.request_uri") != null) {
			url = ((String) request.getAttribute("javax.servlet.forward.request_uri")).trim();
		}
		if (url.length() == 0)
			url = new String(request.getRequestURL());

		String webContext = request.getContextPath().trim();
		int startIndex = url.indexOf(webContext);
		url = url.substring(startIndex + webContext.length());

		String queryString = request.getQueryString().trim();
		if (queryString.length() > 0)
			url = url + "?" + queryString;

		return url;
	}

	public static String accessURL(String url) {
		return accessURL(url, "");
	}

	public static String accessURL(String url, String charSet) {
		String returnStr = "";
		try {
			URL lurl_URL = new URL(url);
			InputStream inputStream = lurl_URL.openStream();

			returnStr = getInputStreamAsString(inputStream, charSet);
			inputStream.close();
		} catch (Exception e) {
			printMsg("accessURL()", e.getMessage() + " 请检查相应URL是否有效.");
		}

		return returnStr;
	}

	private static void printMsg(String as_MethodName, String as_Msg) {
		System.out.println(HttpUtil.class.getName() + "." + as_MethodName + " : " + as_Msg);
	}

	public static byte[] getInputStreamAsByteArray(InputStream ais_In) {
		byte[] larrbyte_Return = null;

		if (ais_In == null) {
			return null;
		}
		try {
			int li_TotalLength = 0;
			Vector<Object> lvector_Content = new Vector<>();
			Vector<Object> lvector_ContentLength = new Vector<>();
			while (true) {
				byte[] larrbyte_Buffer = new byte[1024];
				int li_BytesRead = ais_In.read(larrbyte_Buffer);
				if (li_BytesRead == -1)
					break;
				li_TotalLength += li_BytesRead;
				byte[] larrbyte_Read = new byte[li_BytesRead];
				for (int i = 0; i < li_BytesRead; i++) {
					larrbyte_Read[i] = larrbyte_Buffer[i];
				}

				lvector_Content.addElement(larrbyte_Read);
				lvector_ContentLength.addElement(Integer.toString(li_BytesRead));
			}

			larrbyte_Return = new byte[li_TotalLength];
			int li_Index = 0;
			for (int i = 0; i < lvector_ContentLength.size(); i++) {
				byte[] larrbyte_IthRead = (byte[]) lvector_Content.elementAt(i);
				String ls_BytesRead = (String) lvector_ContentLength.elementAt(i);
				int li_ByteRead = Integer.parseInt(ls_BytesRead, 0);
				for (int j = 0; j < li_ByteRead; j++) {
					larrbyte_Return[li_Index] = larrbyte_IthRead[j];
					li_Index++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return larrbyte_Return;
	}

	public static String getInputStreamAsString(InputStream inputStream, String charSet) {
		if (inputStream == null) {
			return null;
		}

		byte[] larrbyte_Return = getInputStreamAsByteArray(inputStream);
		if (larrbyte_Return == null)
			return null;
		try {
			return new String(larrbyte_Return, charSet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new String(larrbyte_Return);
	}
	
	/***
     * 获取 request 中 json 字符串的内容
     * 
     * @param request
     * @return : <code>byte[]</code>
     * @throws IOException
     */
    public static String getRequestJsonString(HttpServletRequest request) {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            try{
            	return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
            }catch(Exception e) {
            	return "";
            }
        // POST
        } else {
            return getRequestPostStr(request);
        }
    }
    
    /***
     * 获取 request 字节数组
     * 
     * @param request
     * @return : <code>byte[]</code>
     * @throws IOException
     */
    public static byte[] getRequestBytes(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            try{
            	return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"").getBytes();
            }catch(Exception e) {
            	return "".getBytes();
            }
        // POST
        } else {
            return getRequestPostBytes(request);
        }
    }

    /**      
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request) {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = -1;
			try {
				readlen = request.getInputStream().read(buffer, i,
				        contentLength - i);
			} catch (IOException e) {
				return buffer;
			}
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    /**      
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    private static String getRequestPostStr(HttpServletRequest request) {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        try {
			return new String(buffer, charEncoding);
		} catch (UnsupportedEncodingException e) {
			return "";
		}
    }
}
