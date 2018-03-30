package sin.test.mvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = Exception.class)
	public String error(Exception e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "page/error";
	}
}
