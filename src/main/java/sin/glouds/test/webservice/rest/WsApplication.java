package sin.glouds.test.webservice.rest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

@ApplicationPath("/")
public class WsApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> hashSet = new HashSet<>();
		hashSet.add(WsHelloWorld.class);
		return hashSet;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		ResourceConfig config = new PackagesResourceConfig("sin.glouds.test.webservice.rest");
		HttpServer server = GrizzlyServerFactory.createHttpServer("http://127.0.0.1:8899/ws", config);
		server.start();
		try {
			TimeUnit.SECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
