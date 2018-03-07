package sin.glouds.test.webservice.client;

public class ClientTest {

	public static void main(String[] args) {
		WsTest test = new WsTestService().getWsTestPort();
		System.out.println(test.getString("glouds"));
		System.out.println(test.getAge());
	}
}
