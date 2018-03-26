package sin.test.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/mvc")
public class HelloMvcController {

	@RequestMapping("/hello")
	public String helloWorld() {
		System.out.println(new Date());
		return "page/helloWorld";
	}
	
	@RequestMapping("/error")
	public String error() {
		throw new RuntimeException("异常测试");
	}
}
