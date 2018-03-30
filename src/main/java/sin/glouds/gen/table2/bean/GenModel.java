package sin.glouds.gen.table2.bean;

public class GenModel {

	private Integer id;
	private String basePackage;
	private String baseCodeFilePath;
	private String basePageFilePath;
	private String classNamePrefixIgnoreCase;
	private String classNamePrefix;
	private String pageNamePrefix;
	private String version;
	private String author;
	private String date;
	private GenTable genTable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getBaseCodeFilePath() {
		return baseCodeFilePath;
	}

	public void setBaseCodeFilePath(String baseCodeFilePath) {
		this.baseCodeFilePath = baseCodeFilePath;
	}

	public String getBasePageFilePath() {
		return basePageFilePath;
	}

	public void setBasePageFilePath(String basePageFilePath) {
		this.basePageFilePath = basePageFilePath;
	}

	public String getClassNamePrefixIgnoreCase() {
		return classNamePrefixIgnoreCase;
	}

	public void setClassNamePrefixIgnoreCase(String classNamePrefixIgnoreCase) {
		this.classNamePrefixIgnoreCase = classNamePrefixIgnoreCase;
	}

	public String getClassNamePrefix() {
		return classNamePrefix;
	}

	public void setClassNamePrefix(String classNamePrefix) {
		this.classNamePrefix = classNamePrefix;
	}

	public String getPageNamePrefix() {
		return pageNamePrefix;
	}

	public void setPageNamePrefix(String pageNamePrefix) {
		this.pageNamePrefix = pageNamePrefix;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public GenTable getGenTable() {
		return genTable;
	}

	public void setGenTable(GenTable genTable) {
		this.genTable = genTable;
	}

}
