package sin.glouds.controller;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sin.glouds.beans.Data;
import sin.glouds.util.HttpUtil;
import sin.glouds.util.PropertyUtil;
import sin.glouds.util.StringUtil;

@Controller
@RequestMapping("glouds")
public class GloudsController extends BaseController {

	@ResponseBody
	@RequestMapping("checkAndroidUpdate")
	public Data checkAndroidUpdate(@RequestParam(required = true) String versionCode) {
		String newestVersion = PropertyUtil.propertyUtil.getProperty("appNewestVersion");
		if(!StringUtil.isEmpty(newestVersion) && !versionCode.equals(newestVersion))
			return Data.SUCCESS.setData("/sins/files/SinA.apk");
		return Data.SUCCESS.setData("");
	}
	
	@SuppressWarnings("deprecation")
	@ResponseBody
	@RequestMapping("showMessage")
	public String showRequestData(HttpServletRequest request) {
		String str = "";
		str = HttpUtil.getRequestJsonString(request);
		System.out.println(str);
		KV k = gson.fromJson(URLDecoder.decode(str), KV.class);
		System.out.println(k.getName());
		return str;
	}
	public class KV{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
}
