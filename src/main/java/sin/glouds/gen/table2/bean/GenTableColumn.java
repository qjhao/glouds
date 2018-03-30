package sin.glouds.gen.table2.bean;

public class GenTableColumn {

	private Integer id;
	private String name;
	private String comment;
	private String type;
	private String fieldType;
	private String fieldName;
	private String fieldNameInFunction;
	private Boolean isPrimaryKey;
	private Boolean isForignKey;
	private String isNull;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Boolean getIsPrimaryKey() {
		return isPrimaryKey;
	}

	public void setIsPrimaryKey(Boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

	public Boolean getIsForignKey() {
		return isForignKey;
	}

	public void setIsForignKey(Boolean isForignKey) {
		this.isForignKey = isForignKey;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getFieldNameInFunction() {
		return fieldNameInFunction;
	}

	public void setFieldNameInFunction(String fieldNameInFunction) {
		this.fieldNameInFunction = fieldNameInFunction;
	}

}
