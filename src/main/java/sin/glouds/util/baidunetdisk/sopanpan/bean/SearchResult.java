package sin.glouds.util.baidunetdisk.sopanpan.bean;

public final class SearchResult {
	private String url;
	private String title;
	private String clickAmount;
	private String date;

	public SearchResult(String url, String title, String clickAmount, String date) {
		this.url = url;
		this.title = title;
		this.clickAmount = clickAmount;
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getClickAmount() {
		return clickAmount;
	}

	public void setClickAmount(String clickAmount) {
		this.clickAmount = clickAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
