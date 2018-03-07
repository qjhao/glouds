package sin.glouds.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello/{username}")
	public String hello(@PathVariable("username") String username, Model model) {
		model.addAttribute("username", username);
		return "hello";
	}
}
