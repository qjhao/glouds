package sin.glouds.util.baidunetdisk.sopanpan.bean;

public class SoPanInfo {

	private static final String BASE_URL = "http://www.sopanpan.com/";
	private static final String COMMAND = "search";
	private static final String SUFFIX = "-0.html";
	
	private String url;
	private String key;
	private TYPE type;
	
	public SoPanInfo(String key, TYPE type) {
		this.key = key;
		this.type = type;
		this.url = BASE_URL + COMMAND + "/" + key + "-" + type.ordinal() + SUFFIX;
	}
	
	
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}
	
	public String getBaseUrl() {
		return BASE_URL;
	}

	public static enum TYPE {
		全部,视频,音频,图片,文档,软件,压缩包,种子
	}
}
