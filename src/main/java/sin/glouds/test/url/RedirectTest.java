package sin.glouds.test.url;

import java.net.URL;
import java.net.URLConnection;

public class RedirectTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://oauth.kaola.com/oauth/authorize?response_type=token&client_id=3f845bfa55923fac44993d2fb51f8ed9&redirect_uri=http://www.kaola.com&state=mycode");
		URLConnection connection = url.openConnection();
		connection.connect();
	}
}
