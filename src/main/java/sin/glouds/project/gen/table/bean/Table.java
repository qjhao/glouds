package sin.glouds.project.gen.table.bean;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private String tableName;
	private String entityName;
	private List<Column> columns = new ArrayList<>();
	private List<Row> rows = new ArrayList<>();
	private List<PrimaryKey> primaryKeys = new ArrayList<>();
	private List<ForeignKey> foreignKeys = new ArrayList<>();
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public List<Row> getRows() {
		return rows;
	}
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	public List<PrimaryKey> getPrimaryKeys() {
		return primaryKeys;
	}
	public void setPrimaryKeys(List<PrimaryKey> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}
	public List<ForeignKey> getForeignKeys() {
		return foreignKeys;
	}
	public void setForeignKeys(List<ForeignKey> foreignKeys) {
		this.foreignKeys = foreignKeys;
	}
	@Override
	public String toString() {
		return "Table [tableName=" + tableName + ", entityName=" + entityName + ", columns=" + columns + ", rows="
				+ rows + ", primaryKeys=" + primaryKeys + ", foreignKeys=" + foreignKeys + "]";
	}
	
}
