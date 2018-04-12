package sin.glouds.gen.table2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sin.glouds.gen.table2.bean.ColumnInfo;
import sin.glouds.gen.table2.bean.DatabaseInfo;
import sin.glouds.gen.table2.bean.TableInfo;
import sin.glouds.gen.table2.core.DatabaseType;

public class GenUtil {

	public static List<TableInfo> getTableList(DatabaseInfo info) {
		if (checkDatabaseInfo(info)) {
			String sql = "";
			switch (info.getDatabaseType()) {
			case MYSQL:
				sql = "SELECT t.table_name AS name,t.TABLE_COMMENT AS comments FROM information_schema.`TABLES` t WHERE t.TABLE_SCHEMA = (select database()) ORDER BY t.TABLE_NAME";
				break;
			case ORACLE:
				sql = "SELECT t.TABLE_NAME AS name, c.COMMENTS AS comments FROM user_tables t, user_tab_comments c WHERE t.table_name = c.table_name ORDER BY t.TABLE_NAME";
				break;
			case SQLSERVER:
				sql = "SELECT t.name AS name,b.value AS comments FROM sys.objects t LEFT JOIN sys.extended_properties b ON b.major_id=t.object_id and b.minor_id=0 and b.class=1 AND b.name='MS_Description' WHERE t.type='U' ORDER BY t.name";
				break;
			default:
				throw new IllegalArgumentException("查询失败，不支持的数据库类型");
			}
			Connection connection = null;
			try {
				connection = openConnection(info.getDriverClassName(), info.getUrl(), info.getUsername(),
						info.getPassword());
			} catch (Exception e) {
				throw new RuntimeException("数据库连接失败，请检查连接参数");
			}
			
			try {
				List<TableInfo> tableInfos = new ArrayList<>();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String tableName = rs.getString("name");
					String tableComments = rs.getString("comments");
					if(tableName == null)
						continue;
					if(tableComments == null)
						tableComments = "";
					TableInfo tableInfo = new TableInfo(tableName, tableComments);
					tableInfos.add(tableInfo);
				}
				rs.close();
				ps.close();
				connection.close();
				return tableInfos;
			}catch(SQLException e) {
				throw new RuntimeException("数据查询失败，表数据查询出现异常");
			}
		} else {
			throw new IllegalArgumentException("数据库连接失败，数据库连接参数不全");
		}
	}
	
	public static List<ColumnInfo> getColumnList(DatabaseInfo info, TableInfo tableInfo) {
		if (checkDatabaseInfo(info) && checkTableInfo(tableInfo)) {
			String sql = "";
			switch (info.getDatabaseType()) {
			case MYSQL:
				sql = "SELECT t.COLUMN_NAME AS name, (CASE WHEN t.IS_NULLABLE = 'YES' THEN 'true' ELSE 'false' END) AS isNull, (t.ORDINAL_POSITION * 10) AS sort,t.COLUMN_COMMENT AS comments,t.COLUMN_TYPE AS type FROM information_schema.COLUMNS t WHERE t.TABLE_SCHEMA = (select database()) AND t.TABLE_NAME = ? ORDER BY t.ORDINAL_POSITION";
				break;
			case ORACLE:
				sql = "SELECT t.COLUMN_NAME AS name, (CASE WHEN t.NULLABLE = 'Y' THEN 'true' ELSE 'false' END) AS isNull, (t.COLUMN_ID * 10) AS sort, c.COMMENTS AS comments, decode(t.DATA_TYPE,'DATE',t.DATA_TYPE || '(' || t.DATA_LENGTH || ')', 'VARCHAR2', t.DATA_TYPE || '(' || t.DATA_LENGTH || ')', 'VARCHAR', t.DATA_TYPE || '(' || t.DATA_LENGTH || ')', 'NVARCHAR2', t.DATA_TYPE || '(' || t.DATA_LENGTH/2 || ')', 'CHAR', t.DATA_TYPE || '(' || t.DATA_LENGTH || ')', 'NUMBER',t.DATA_TYPE || (nvl2(t.DATA_PRECISION,nvl2(decode(t.DATA_SCALE,0,null,t.DATA_SCALE), '(' || t.DATA_PRECISION || ',' || t.DATA_SCALE || ')', '(' || t.DATA_PRECISION || ')'),'(18)')),t.DATA_TYPE) AS type FROM user_tab_columns t, user_col_comments c WHERE t.TABLE_NAME = c.table_name AND t.COLUMN_NAME = c.column_name AND t.TABLE_NAME = upper(？) ORDER BY t.COLUMN_ID";
				break;
			case SQLSERVER:
				sql = "SELECT t.COLUMN_NAME AS name, (CASE WHEN t.IS_NULLABLE = 'YES' THEN 'true' ELSE 'false' END) AS isNull, (t.ORDINAL_POSITION * 10) AS sort,isnull(g.[value], '') AS comments, (t.DATA_TYPE+ CASE WHEN t.DATA_TYPE IN ('varchar','char','nvarchar','nchar') THEN '('+CONVERT(VARCHAR,t.CHARACTER_MAXIMUM_LENGTH)+')' WHEN t.DATA_TYPE IN ('numeric','decimal') THEN '('+CONVERT(VARCHAR,t.NUMERIC_PRECISION_RADIX)+','+CONVERT(VARCHAR,ISNULL(t.NUMERIC_SCALE, 0))+')' ELSE '' END) AS type FROM INFORMATION_SCHEMA.COLUMNS t INNER JOIN sys.sysobjects o ON t.TABLE_NAME=o.name AND SCHEMA_NAME(o.uid)=t.TABLE_SCHEMA LEFT JOIN sys.extended_properties g ON o.id = g.major_id AND t.ORDINAL_POSITION = g.minor_id AND g.name='MS_Description' WHERE t.TABLE_SCHEMA = (SCHEMA_NAME()) AND t.TABLE_NAME = ? ORDER BY t.ORDINAL_POSITION";
				break;
			default:
				throw new IllegalArgumentException("查询失败，不支持的数据库类型");
			}
			Connection connection = null;
			try {
				connection = openConnection(info.getDriverClassName(), info.getUrl(), info.getUsername(),
						info.getPassword());
			} catch (Exception e) {
				throw new RuntimeException("数据库连接失败，请检查连接参数");
			}
			
			try {
				List<ColumnInfo> columnInfos = new ArrayList<>();
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, tableInfo.getName());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String columnName = rs.getString("name");
					String columnComments = rs.getString("comments");
					String type = rs.getString("type");
					boolean isNull = rs.getBoolean("isNull");
					if(columnName == null)
						continue;
					if(columnComments == null)
						columnComments = "";
					ColumnInfo columnInfo = new ColumnInfo(columnName, columnComments, type, isNull);
					columnInfos.add(columnInfo);
				}
				rs.close();
				ps.close();
				connection.close();
				return columnInfos;
			}catch(SQLException e) {
				throw new RuntimeException("数据查询失败，表数据查询出现异常");
			}
		} else {
			throw new IllegalArgumentException("数据库连接失败，数据库连接参数不全");
		}
	}

	private static Connection openConnection(String driverClassName, String url, String username, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName(driverClassName);
		return DriverManager.getConnection(url, username, password);
	}
	
	public static List<String> getPKList(DatabaseInfo info, TableInfo tableInfo) {
		if (checkDatabaseInfo(info) && checkTableInfo(tableInfo)) {
			String sql = "";
			switch (info.getDatabaseType()) {
			case MYSQL:
				sql = "SELECT lower(au.COLUMN_NAME) AS columnName FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE au WHERE au.TABLE_NAME = ? AND au.TABLE_SCHEMA = (SCHEMA_NAME())";
				break;
			case ORACLE:
				sql = "SELECT lower(cu.COLUMN_NAME) AS columnName FROM user_cons_columns cu, user_constraints au WHERE cu.constraint_name = au.constraint_name AND au.constraint_type = 'P' AND au.table_name = upper(?)";
				break;
			case SQLSERVER:
				sql = "SELECT lower(au.COLUMN_NAME) AS columnName FROM information_schema.COLUMNS au WHERE au.TABLE_SCHEMA = (select database()) AND au.COLUMN_KEY='PRI' AND au.TABLE_NAME = ?";
				break;
			default:
				throw new IllegalArgumentException("查询失败，不支持的数据库类型");
			}
			Connection connection = null;
			try {
				connection = openConnection(info.getDriverClassName(), info.getUrl(), info.getUsername(),
						info.getPassword());
			} catch (Exception e) {
				throw new RuntimeException("数据库连接失败，请检查连接参数");
			}
			
			try {
				List<String> pks = new ArrayList<>();
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, tableInfo.getName());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String columnName = rs.getString("columnName");
					if(columnName == null)
						continue;
					pks.add(columnName);
				}
				rs.close();
				ps.close();
				connection.close();
				return pks;
			}catch(SQLException e) {
				throw new RuntimeException("数据查询失败，表数据查询出现异常");
			}
		} else {
			throw new IllegalArgumentException("数据库连接失败，数据库连接参数不全");
		}
	}

	private static boolean checkDatabaseInfo(DatabaseInfo info) {
		return info.getDatabaseType() != null && info.getDatabaseType() != DatabaseType.OTHERS && info.getUrl() != null
				&& !info.getUrl().isEmpty() && info.getUsername() != null && !info.getUsername().isEmpty()
				&& info.getPassword() != null && !info.getPassword().isEmpty();
	}
	
	private static boolean checkTableInfo(TableInfo info) {
		return info != null && info.getName() != null && !"".equals(info.getName());
	}
	
	public void temp() {
		String sql = "SELECT lower(au.COLUMN_NAME) AS columnName FROM information_schema.`COLUMNS` au WHERE au.TABLE_SCHEMA = (select database()) AND au.COLUMN_KEY='PRI' AND au.TABLE_NAME = ?";
		System.out.println(sql);
	}
	
}
