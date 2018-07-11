package sin.glouds.test.webservice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class WsHelloWorld {

	@GET
	@Produces("application/json")
	public String getMessage() {
		return "Hello World";
	}
}
