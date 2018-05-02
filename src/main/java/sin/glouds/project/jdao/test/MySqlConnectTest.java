package sin.glouds.project.jdao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySqlConnectTest {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://59.110.222.94", "root", "123");
		PreparedStatement preparedStatement = connection.prepareStatement("select * from sin_fir_user");
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println(resultSet.next());
	}
}
