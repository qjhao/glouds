package sin.glouds.project.gen.table2.bean;

public class ColumnInfo {

	private String name;
	private String comment;
	private String type;
	private String fieldType;
	private String fieldName;
	private String fieldNameInFunction;
	private Boolean isPrimaryKey;
	private Boolean isForignKey;
	private Boolean isNull;

	public ColumnInfo() {
		super();
	}

	public ColumnInfo(String name, String comment, String type, String fieldType, String fieldName,
			String fieldNameInFunction, Boolean isPrimaryKey, Boolean isForignKey, Boolean isNull) {
		super();
		this.name = name;
		this.comment = comment;
		this.type = type;
		this.fieldType = fieldType;
		this.fieldName = fieldName;
		this.fieldNameInFunction = fieldNameInFunction;
		this.isPrimaryKey = isPrimaryKey;
		this.isForignKey = isForignKey;
		this.isNull = isNull;
	}

	public ColumnInfo(String name, String comment, String type, Boolean isNull) {
		super();
		this.name = name;
		this.comment = comment;
		this.type = type;
		this.isNull = isNull;
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

	public Boolean getIsNull() {
		return isNull;
	}

	public void setIsNull(Boolean isNull) {
		this.isNull = isNull;
	}

	public String getFieldNameInFunction() {
		return fieldNameInFunction;
	}

	public void setFieldNameInFunction(String fieldNameInFunction) {
		this.fieldNameInFunction = fieldNameInFunction;
	}

	@Override
	public String toString() {
		return "ColumnInfo [name=" + name + ", comment=" + comment + ", type=" + type + ", fieldType=" + fieldType
				+ ", fieldName=" + fieldName + ", fieldNameInFunction=" + fieldNameInFunction + ", isPrimaryKey="
				+ isPrimaryKey + ", isForignKey=" + isForignKey + ", isNull=" + isNull + "]";
	}

}
