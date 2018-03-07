package sin.glouds.gen.table.bean;

public class Column {
	private String tableName;
	private String columnName;
	private Integer dataType;
	private String typeName;
	private Integer columnSize;
	private Integer decimalDigits;
	private Integer nullable;
	private String remarks;
	private String columnDef;
	private Integer ordinalPosition;
	private String isNullable;
	private String scopeTable;
	private String isAutoincrement;
	private boolean primaryKey;
	private boolean foreignKey;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getColumnSize() {
		return columnSize;
	}
	public void setColumnSize(Integer columnSize) {
		this.columnSize = columnSize;
	}
	public Integer getDecimalDigits() {
		return decimalDigits;
	}
	public void setDecimalDigits(Integer decimalDigits) {
		this.decimalDigits = decimalDigits;
	}
	public Integer getNullable() {
		return nullable;
	}
	public void setNullable(Integer nullable) {
		this.nullable = nullable;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getColumnDef() {
		return columnDef;
	}
	public void setColumnDef(String columnDef) {
		this.columnDef = columnDef;
	}
	public Integer getOrdinalPosition() {
		return ordinalPosition;
	}
	public void setOrdinalPosition(Integer ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public String getScopeTable() {
		return scopeTable;
	}
	public void setScopeTable(String scopeTable) {
		this.scopeTable = scopeTable;
	}
	public String getIsAutoincrement() {
		return isAutoincrement;
	}
	public void setIsAutoincrement(String isAutoincrement) {
		this.isAutoincrement = isAutoincrement;
	}
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	public boolean isForeignKey() {
		return foreignKey;
	}
	public void setForeignKey(boolean foreignKey) {
		this.foreignKey = foreignKey;
	}
	@Override
	public String toString() {
		return "Column [tableName=" + tableName + ", columnName=" + columnName + ", dataType=" + dataType
				+ ", typeName=" + typeName + ", columnSize=" + columnSize + ", decimalDigits=" + decimalDigits
				+ ", nullable=" + nullable + ", remarks=" + remarks + ", columnDef=" + columnDef + ", ordinalPosition="
				+ ordinalPosition + ", isNullable=" + isNullable + ", scopeTable=" + scopeTable + ", isAutoincrement="
				+ isAutoincrement + ", primaryKey=" + primaryKey + ", foreignKey=" + foreignKey + "]";
	}
	
}
