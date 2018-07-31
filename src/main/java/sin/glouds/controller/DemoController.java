package sin.glouds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/fatherAndChildTable")
	public String fatherAndChildTableDemo() {
		return "demo/fatherAndChildTableDemo";
	}
	
	@RequestMapping("/gooFlow")
	public String gooFlowDemo() {
		return "demo/gooFlowDemo";
	}
	
	@RequestMapping("/demo")
	public String demo(String name) {
		return "demo/" + name;
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
