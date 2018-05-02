package sin.glouds.test.sql;

import java.sql.ResultSet;

import sin.glouds.project.jdao.connector.JConnector;

/**
 * so 蛋疼
 * 
 * @author glouds
 * @see jdao
 *
 */
public class NickName {
	/**
	 * 这是设置了 连接字符串编码 不设置会有惊喜的
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ResultSet rs = JConnector.preparedStatement("select name as \"用户名\",pwd as '密码' from sin_fir_user").executeQuery();
		if(rs.next()) {
			System.out.println(rs.getString("用户名"));
			System.out.println(rs.getBoolean("name"));
			System.out.println(rs.getString("密码"));
			System.out.println(rs.getBoolean("pwd"));
		}
	}
}
