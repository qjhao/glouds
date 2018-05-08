package test.kingdee.base.material;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) throws IOException {
		//System.out.println(getToken());
		getList();
	}
	
	public static String getList() throws IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("data", new Data());
		URL url = new URL("http://192.168.8.251/k3api/Material/GetList?Token=D5CDFE391075ECFF0ADAEB4E5AB8951C27B9A5872EA74724B8AB202468C97117C1ABBB746036C745");
		URLConnection connection = url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.getOutputStream().write(new Gson().toJson(map).getBytes());
		connection.getOutputStream().flush();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		String data = "";
		while ((line = reader.readLine()) != null) {
			data = data + line;
		}
		System.out.println(data);
		return data;
	}

	public static String getToken() throws IOException {
		URL url = new URL("http://192.168.8.251/k3api/Token/Create?authorityCode=1a937d1a68db7c5a74988293d712a2849d9c1a358a1bfb82");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		String data = "";
		while ((line = reader.readLine()) != null) {
			data = data + line;
		}
		return data;
	}
}

class Data {
	private String Top = "";
	private String PageSize = "";
	private String PageIndex = "";
	private String Fields = "";
	private String Filter = "";
	private String OrderBy = "";
	private Boolean ShowForbidden = false;

	public String getTop() {
		return Top;
	}

	public void setTop(String top) {
		Top = top;
	}

	public String getPageSize() {
		return PageSize;
	}

	public void setPageSize(String pageSize) {
		PageSize = pageSize;
	}

	public String getPageIndex() {
		return PageIndex;
	}

	public void setPageIndex(String pageIndex) {
		PageIndex = pageIndex;
	}

	public String getFields() {
		return Fields;
	}

	public void setFields(String fields) {
		Fields = fields;
	}

	public String getFilter() {
		return Filter;
	}

	public void setFilter(String filter) {
		Filter = filter;
	}

	public String getOrderBy() {
		return OrderBy;
	}

	public void setOrderBy(String orderBy) {
		OrderBy = orderBy;
	}

	public Boolean getShowForbidden() {
		return ShowForbidden;
	}

	public void setShowForbidden(Boolean showForbidden) {
		ShowForbidden = showForbidden;
	}

}
