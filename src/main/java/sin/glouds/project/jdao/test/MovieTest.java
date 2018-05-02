package sin.glouds.project.jdao.test;

import java.sql.SQLException;

import sin.glouds.project.jdao.connector.JConnector;

public class MovieTest {

	public static void main(String[] args) throws SQLException {
		System.out.println(JConnector.preparedStatement("insert into movie (name) values ('vivia')").executeUpdate());
	}
}
