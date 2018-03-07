package sin.gen.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sin.gen.service.GenService;
import sin.glouds.controller.BaseController;

@Controller
public class GenController extends BaseController {

	@Resource
	private GenService genService;
	
	@ResponseBody
	@RequestMapping("/gen/getTableNames")
	public String getTableNames() throws SQLException {
		return gson.toJson(genService.geTableNames());
	}
}
