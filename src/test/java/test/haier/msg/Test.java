package test.haier.msg;

import java.sql.ResultSet;
import java.sql.SQLException;

import sin.glouds.project.jdao.connector.JConnector;

public class Test {

	public static void main(String[] args) throws SQLException {
		ResultSet resultSet = JConnector.preparedStatement("select * from hsicrm_wo_shortmessage where 1=1 and (hsicrm_issuccess is null or hsicrm_issuccess='0' or hsicrm_issuccess='2' )").executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
	}
}
