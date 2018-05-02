package sin.glouds.project.jdao.connector;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

import sin.glouds.project.jdao.annotation.Row;
import sin.glouds.project.jdao.context.JContext;
import sin.glouds.project.jdao.context.TempData;
import sin.glouds.project.jdao.util.StringUtil;

public class JSession {
	public void save(Object obj) {
		Field[] fields;
		if(!TempData.fields.containsKey(obj.getClass())) {
			TempData.fields.put(obj.getClass(), Arrays.asList(obj.getClass().getDeclaredFields()));
		}
		fields = (Field[])TempData.fields.get(obj.getClass()).toArray();
		if(fields == null || fields.length == 0)
			return;
		HashMap<String, Object> entries = new HashMap<>();
		for(Field field : fields) {
			field.setAccessible(true);
			if(field.getAnnotation(Row.class) != null)
				try {
					entries.put(StringUtil.convertFromBeanToSql(field.getName()), StringUtil.convertFromBeanToSql(field.get(obj) + ""));
				} catch (Exception e) {
					throw new RuntimeException("illegal field : " + e.getMessage());
				}
		}
		StringBuilder sb = new StringBuilder("insert into ");
		sb.append(StringUtil.convertFromBeanToSqlTable(obj.getClass().getSimpleName()));
		sb.append(" (");
		Object[] keys = entries.keySet().toArray();
		for(Object key : keys) {
			sb.append((String)key);
			sb.append(",");
		}
		if(sb.charAt(sb.length() - 1) == ',')
			sb.deleteCharAt(sb.length() - 1);
		sb.append(") values (");
		for(Object key : keys) {
			Object value = entries.get((String)key);
			if(value.getClass() == String.class)
				sb.append("'").append(value).append("'");
			else
				sb.append(value + "");
			sb.append(",");
		}
		if(sb.charAt(sb.length() - 1) == ',')
			sb.deleteCharAt(sb.length() - 1);
		sb.append(")");
		if("true".equals(JContext.getProperty("showsql"))) {
			System.out.println(sb.toString());
		}
		try {
			int rows = JConnector.preparedStatement(sb.toString()).executeUpdate();
			if(rows != 1)
				throw new SQLException("error count");
		} catch (SQLException e) {
			throw new RuntimeException("save failed : " + e.getMessage());
		}
	}
	
	public static void excute(String sql, Object... objs) throws Exception {
		PreparedStatement ps = JConnector.preparedStatementWithKey(sql);
		for(int i = 0; i < objs.length; i++) {
			ps.setObject(i + 1, objs[i]);
		}
		ps.execute();
	}
	
	public static void main(String[] args) throws Exception {
		excute("insert into sin_fir_user (name, pwd, create_time) values (?,?,?)", "cyb", "cyb", "cyb");
	}
}
