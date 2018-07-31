package sin.glouds.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sin.glouds.util.StringUtil;

@Controller
@RequestMapping("")
public class LoginController {

	@RequestMapping("login")
	public String login(HttpServletRequest request) {
	    try {
	    	String username = request.getParameter("username");
		    String password = request.getParameter("password");
		    System.out.println("username:" + username);
		    System.out.println("password:" + password);
		    if(StringUtil.isNotBlank(username) && StringUtil.isNotBlank("password")) {
		    	SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
		    	return "sys/index";
		    }
	    }catch(Exception e) {
	    	
	    }
	    return "sys/login";
	}
	
	@RequestMapping("logout")
	public String logout() {
		return "sys/login";
	}
}
