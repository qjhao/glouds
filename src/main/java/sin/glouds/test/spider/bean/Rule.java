package sin.glouds.test.spider.bean;

public class Rule {

	private String url;
	private String[] params;
	private String[] values;
	private String resultTagName;
	private int type = ID;
	private int requestMethod = GET;

	public static final int GET = 0;
	public static final int POST = 1;

	public static final int CLASS = 0;
	public static final int ID = 1;
	public static final int SELECTION = 2;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public String getResultTagName() {
		return resultTagName;
	}

	public void setResultTagName(String resultTagName) {
		this.resultTagName = resultTagName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(int requestMethod) {
		this.requestMethod = requestMethod;
	}

	public Rule() {

	}

	public Rule(String url, String[] params, String[] values, String resultTagName, int type, int requestMethod) {
		super();
		this.url = url;
		this.params = params;
		this.values = values;
		this.resultTagName = resultTagName;
		this.type = type;
		this.requestMethod = requestMethod;
	}
	
}
