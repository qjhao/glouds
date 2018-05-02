package sin.glouds.project.gen.table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sin.glouds.project.gen.table.bean.Column;
import sin.glouds.project.gen.table.bean.ForeignKey;
import sin.glouds.project.gen.table.bean.PrimaryKey;
import sin.glouds.project.gen.table.bean.Row;
import sin.glouds.project.gen.table.bean.Table;
import sin.glouds.project.jdao.connector.JConnector;
import sin.glouds.util.StringUtil;

public class TableInfo {

	public static Table getTableInfo(String tableName) throws Exception {
		Table table = new Table();
		Connection connection = JConnector.getConnection();
		DatabaseMetaData metaData = connection.getMetaData();
		ResultSet rs = metaData.getPrimaryKeys(null, null, tableName);
		List<PrimaryKey> pks = new ArrayList<>();
		List<ForeignKey> fks = new ArrayList<>();
		while(rs.next()) {
			PrimaryKey primaryKey = new PrimaryKey();
			primaryKey.setKeySeq(rs.getShort("KEY_SEQ"));
			primaryKey.setColumnName(rs.getString("COLUMN_NAME"));
			primaryKey.setPkName(rs.getString("PK_NAME"));
			primaryKey.setTableName(rs.getString("TABLE_NAME"));
			pks.add(primaryKey);
		}
		
		metaData.getExportedKeys(null, null, tableName);
		
		while (rs.next()) {
			ForeignKey foreignKey = new ForeignKey();
			foreignKey.setFkcolumnName(rs.getString("FKCOLUMN_NAME"));
			foreignKey.setFkName(rs.getString("FK_NAME"));
			foreignKey.setFktableName(rs.getString("FKTABLE_NAME"));
			foreignKey.setKeySeq(rs.getShort("KEY_SEQ"));
			foreignKey.setPkcolumnName(rs.getString("PKCOLUMN_NAME"));
			foreignKey.setPkName(rs.getString("PK_NAME"));
			foreignKey.setPktableName(rs.getString("PKTABLE_NAME"));
			fks.add(foreignKey);
		}
		
		rs = metaData.getColumns(null, null, tableName, null);
		
		List<Column> columns = new ArrayList<>();
		while(rs.next()) {
			Column column = new Column();
			column.setColumnDef(rs.getString("COLUMN_DEF"));
			column.setColumnName(rs.getString("COLUMN_NAME"));
			column.setColumnSize(rs.getInt("COLUMN_SIZE"));
			column.setDataType(rs.getInt("DATA_TYPE"));
			column.setDecimalDigits(rs.getInt("DECIMAL_DIGITS"));
			column.setIsAutoincrement(rs.getString("IS_AUTOINCREMENT"));
			column.setIsNullable(rs.getString("IS_NULLABLE"));
			column.setNullable(rs.getInt("NULLABLE"));
			column.setOrdinalPosition(rs.getInt("ORDINAL_POSITION"));
			column.setRemarks(rs.getString("REMARKS"));
			column.setScopeTable(rs.getString("SCOPE_TABLE"));
			column.setTableName("TABLE_NAME");
			column.setTypeName(rs.getString("TYPE_NAME"));
			column.setPrimaryKey(pks.stream().anyMatch((pk) -> pk.getColumnName().equals(column.getColumnName())));
			column.setForeignKey(fks.stream().anyMatch((fk) -> fk.getFkcolumnName().equals(column.getColumnName())));
			columns.add(column);
		}
		
		List<Row> rows = new ArrayList<>();
		
		for(Column column : columns) {
			Row row = new Row();
			row.setColLength(column.getColumnSize());
			row.setColName(column.getColumnName());
			row.setColType(column.getTypeName());
			row.setForeignKey(column.isForeignKey());
			row.setPrimaryKey(column.isPrimaryKey());
			row.setPropLength(column.getColumnSize());
			row.setPropName(StringUtil.columnNameToFieldName(column.getColumnName()));
			row.setPropType(typeMapper.get(column.getDataType()));
			rows.add(row);
		}
		
		table.setPrimaryKeys(pks);
		table.setForeignKeys(fks);
		table.setColumns(columns);
		table.setRows(rows);
		table.setTableName(tableName);
		if(table.getEntityName() == null || "".equals(table.getEntityName())) {
			table.setEntityName(StringUtil.tableNameToClassName(tableName));
		}
		return table;
	}
	
	public static void main(String[] args) throws Exception {
		Table table = getTableInfo("sin_user");
		System.out.println(table);
	}
	
	public static List<Table> getTablesInfo(List<String> names) {
		List<Table> tables = new ArrayList<>();
		
		for(String name : names) {
			try {
				tables.add(getTableInfo(name));
			} catch (Exception e) {
				throw new RuntimeException("查询" + name + "表信息失败");
			}
		}
		
		return tables;
	}
	
	public static List<Table> getTablesInfo(String ... names) {
		List<Table> tables = new ArrayList<>();
		
		for(String name : names) {
			try {
				tables.add(getTableInfo(name));
			} catch (Exception e) {
				throw new RuntimeException("查询表信息失败");
			}
		}
		
		return tables;
	}
	
	@SuppressWarnings("serial")
	private static Map<Integer, String> typeMapper = new HashMap<Integer, String>() {
		{
			put(Types.BIGINT, "Long");
			put(Types.CHAR, "String");
			put(Types.DATE, "Date");
			put(Types.DECIMAL, "BigDecimal");
			put(Types.BOOLEAN, "Boolean");
			put(Types.DOUBLE, "Double");
			put(Types.FLOAT, "Double");
			put(Types.INTEGER, "Integer");
			put(Types.NVARCHAR, "String");
			put(Types.SMALLINT, "Integer");
			put(Types.TIME, "Date");
			put(Types.TIMESTAMP, "Date");
			put(Types.TINYINT, "Integer");
			put(Types.VARCHAR, "String");
			put(-1, "String");
		}
	};
}
