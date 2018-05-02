package sin.glouds.project.jdao.test;

import java.sql.PreparedStatement;

import sin.glouds.project.jdao.connector.JConnector;

public class DdlTest {
	public static void main(String[] args) throws Exception {
		String sql = "CREATE TABLE sin_fir_user (id int auto_increment,name varchar(255) DEFAULT NULL,pwd varchar(255) DEFAULT NULL,create_time varchar(255) DEFAULT NULL,PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
		PreparedStatement ps = JConnector.preparedStatement(sql);
		boolean line = ps.execute();
		System.out.println(line);
	}
}
