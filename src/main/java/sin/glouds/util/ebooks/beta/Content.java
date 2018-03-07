package sin.glouds.util.ebooks.beta;

public class Content {

	private Integer id;
	private String content;
	
	public Content(Integer id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
