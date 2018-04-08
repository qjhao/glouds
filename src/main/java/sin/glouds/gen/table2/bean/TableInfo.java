package sin.glouds.gen.table2.bean;

public class TableInfo {

	private String name;
	private String comments;

	public TableInfo(String name, String comments) {
		this.name = name;
		this.comments = comments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TableInfo [name=" + name + ", comments=" + comments + "]";
	}

}
