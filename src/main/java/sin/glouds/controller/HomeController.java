package sin.glouds.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/home")
public class HomeController {

	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		return "page/helloWorld";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "sys/index";
	}
	
	@RequestMapping("/helloworld")
	public String helloworld(HttpServletRequest request) {
		return "helloworld";
	}
}
