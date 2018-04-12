package sin.glouds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sin.command.util.CommandUtil;

@Controller
@RequestMapping("system")
public class SystemController extends BaseController {

	@RequestMapping("browse")
	@ResponseBody
	public String browse(@RequestParam(required = false) String url) {
		boolean b = CommandUtil.openDefaultBrowser(url);
		return b?"成功打开浏览器":"请检查系统是否支持默认浏览器或请求URL是否合法";
	}
}
