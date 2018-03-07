package sin.glouds.jdao.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sin.glouds.jdao.context.JContext;

public class JConnector {
	private static PreparedStatement ps;
	private static Connection conn;
	
	static {
		try {
			Class.forName(JContext.getProperty("driverName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("driverName is not available" + e.getMessage());
		}
	}
	
	public static PreparedStatement preparedStatement(String sql) {
		try {
			return getConnection().prepareStatement(sql);
		} catch (Exception e) {
			throw new RuntimeException("sql invalid : " + e.getMessage());
		}
	}
	
	public static PreparedStatement preparedStatementWithKey(String sql) {
		try {
			return getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		} catch (Exception e) {
			throw new RuntimeException("sql invalid : " + e.getMessage());
		}
	}
	
	public static PreparedStatement preparedStatement() {
		return ps;
	}
	
	public static Connection getConnection() {
		if(conn == null)
			try {
				conn = DriverManager.getConnection(JContext.getProperty("url"), JContext.getProperty("userName"), JContext.getProperty("password"));
			} catch (SQLException e) {
				throw new RuntimeException("Connect url is not available : " + e.getMessage());
			}
		return conn;
	}
	
	public static void closeConnection() {
		try {
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
			ps = null;
			conn = null;
		}catch(Exception e) {
			throw new RuntimeException("Connection close failed : " + e.getMessage());
		}
	}
	
	public static void closePreparedStatement() {
		try {
			if(ps != null)
				ps.close();
			ps = null;
		}catch(Exception e) {
			throw new RuntimeException("PreparedStatement close failed : " + e.getMessage());
		}
	}
}
