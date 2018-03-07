package sin.glouds.util.ebooks.beta;

public final class EBookInfo {

	private String name;
	private Chapters chapters;
	private Contents contents;
	
	public EBookInfo(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Chapters getChapters() {
		return chapters;
	}
	public void setChapters(Chapters chapters) {
		this.chapters = chapters;
	}
	public Contents getContents() {
		return contents;
	}
	public void setContents(Contents contents) {
		this.contents = contents;
	}
	
	
}
