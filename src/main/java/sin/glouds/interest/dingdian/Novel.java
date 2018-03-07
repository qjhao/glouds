package sin.glouds.interest.dingdian;

public class Novel {

	private String title;
	private String url;
	private String author;
	private String length;
	private String date;
	private String status;
	private String type;
	private String desc;
	private String descUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDescUrl() {
		return descUrl;
	}

	public void setDescUrl(String descUrl) {
		this.descUrl = descUrl;
	}

	@Override
	public String toString() {
		return "Novel [title=" + title + ", url=" + url + ", author=" + author + ", length=" + length + ", date=" + date
				+ ", status=" + status + ", type=" + type + ", desc=" + desc + ", descUrl=" + descUrl + "]";
	}

}
