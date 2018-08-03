package sin.glouds.config.webservice;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sin.glouds.test.webservice.WsTest;

@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean cxfServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), new WsTest());
		endpoint.publish("/test");
		return endpoint;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}
}
