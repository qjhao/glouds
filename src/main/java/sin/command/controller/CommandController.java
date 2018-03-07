package sin.command.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sin.command.bean.RequestData;
import sin.command.bean.ResponseData;
import sin.command.fun.CommandExecutor;
import sin.glouds.controller.BaseController;
import sin.glouds.util.HttpUtil;

@RestController
@RequestMapping("command")
public class CommandController extends BaseController {

	@RequestMapping("exec")
	public String exec(HttpServletRequest request) {
		String requestStr = HttpUtil.getRequestJsonString(request);
		RequestData data = gson.fromJson(requestStr, RequestData.class);
		ResponseData result = CommandExecutor.exec(data);
		return gson.toJson(result);
	}
}
