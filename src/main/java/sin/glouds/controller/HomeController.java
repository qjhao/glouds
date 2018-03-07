package sin.glouds.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sin.glouds.entity.User;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(User user, HttpServletRequest request) {
		return "page/home";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
