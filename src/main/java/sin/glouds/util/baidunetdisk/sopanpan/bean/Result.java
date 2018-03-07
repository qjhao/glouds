package sin.glouds.util.baidunetdisk.sopanpan.bean;

public final class Result {

	private String name;
	private String url;

	public Result(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
