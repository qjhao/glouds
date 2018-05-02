package sin.glouds.project.gen.table2.bean;

import java.util.List;

public class GenTable {

	private Integer id;
	private String name;
	private String comments;
	private String className;
	private List<GenTableColumn> genTableColumns;
	private List<String> primaryKeys;
	private List<String> imports;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<GenTableColumn> getGenTableColumns() {
		return genTableColumns;
	}

	public void setGenTableColumns(List<GenTableColumn> genTableColumns) {
		this.genTableColumns = genTableColumns;
	}

	public List<String> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(List<String> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public List<String> getImports() {
		return imports;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}

}
