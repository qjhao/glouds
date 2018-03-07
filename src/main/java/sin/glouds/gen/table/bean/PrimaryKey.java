package sin.glouds.gen.table.bean;

public class PrimaryKey {

	private String tableCat;
	private String tableSchem;
	private String tableName;
	private String columnName;
	private Short keySeq;
	private String pkName;
	public String getTableCat() {
		return tableCat;
	}
	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}
	public String getTableSchem() {
		return tableSchem;
	}
	public void setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
	}
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
	public Short getKeySeq() {
		return keySeq;
	}
	public void setKeySeq(Short keySeq) {
		this.keySeq = keySeq;
	}
	public String getPkName() {
		return pkName;
	}
	public void setPkName(String pkName) {
		this.pkName = pkName;
	}
	@Override
	public String toString() {
		return "PrimaryKey [tableCat=" + tableCat + ", tableSchem=" + tableSchem + ", tableName=" + tableName
				+ ", columnName=" + columnName + ", keySeq=" + keySeq + ", pkName=" + pkName + "]";
	}
	
	
}
