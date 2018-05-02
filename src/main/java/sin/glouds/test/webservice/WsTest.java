package sin.glouds.test.webservice;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import sin.glouds.project.jdao.connector.JConnector;

@WebService
public class WsTest {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:10810/service/WsTest", new WsTest());
	}
	
	public String getString(String name) {
		return "your name is " + name;
	}
	
	public int getAge() {
		ResultSet resultSet;
		try {
			resultSet = JConnector.preparedStatement("select count(*) from novel").executeQuery();
			if(resultSet.next())
				return resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Person getPerson(String name) {
		Person person = new Person();
		person.setName(name);
		person.setAge(getAge());
		return person;
	}
	
	public String parsePerson(Person person) {
		return person.getName() + " " + person.getAge();
	}
}
