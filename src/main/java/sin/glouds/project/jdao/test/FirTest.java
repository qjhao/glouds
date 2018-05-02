package sin.glouds.project.jdao.test;

import sin.glouds.project.jdao.connector.JConnector;

public class FirTest {
	public static void main(String[] args) throws Exception {
		System.out.println(JConnector.preparedStatement("select 'hello' from dual").executeQuery().next());
	}
}
