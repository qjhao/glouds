package sin.glouds.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sin.glouds.enums.FilterType;
import sin.glouds.util.StringUtil;

@Controller
@RequestMapping("/jsoup")
public class JsoupController extends BaseController {

	private Map<String, Document> contents = new HashMap<>();
	
	@RequestMapping("/pageContent")
	@ResponseBody
	public String getPageContent(@RequestParam String url) {
		try {
			url = URLDecoder.decode(url, "utf-8");
			if(!url.startsWith("http")) {
				url = "http://" + url;
			}
		} catch (UnsupportedEncodingException e2) {
			return StringUtil.getStackTrace(e2);
		}
		System.out.println(url);
		try {
			Document doc = Jsoup.connect(url).timeout(5000).get();
			contents.put(url, doc);
			return doc.html();
		}catch(IOException e) {
			if(e instanceof UnknownHostException || e instanceof ConnectException) {
				try {
					Document doc = Jsoup.connect(url).timeout(5000).get();
					contents.put(url, doc);
					return doc.html();
				}catch(IOException e1) {
					return StringUtil.getStackTrace(e1);
				}
			}else {
				return StringUtil.getStackTrace(e);
			}
		}
	}
	
	@RequestMapping("/rootSearch")
	@ResponseBody
	public String rootSearch(@RequestParam String url, @RequestParam String type, @RequestParam String value) {
		if(StringUtil.isEmpty(url) || StringUtil.isEmpty(type) || StringUtil.isEmpty(value)) {
			return "参数不能为空";
		}
		if(!contents.containsKey(url)) {
			return "请先获取网页内容";
		}
		if(!FilterType.typeMap.containsKey(type)) {
			return "不存在的筛选类型";
		}
		Document doc = contents.get(url);
		FilterType type2 = FilterType.typeMap.get(type);
		String content = "";
		switch (type2) {
		case ID:
			content = doc.getElementById(value).html();
			break;
		case CLASS:
			content = doc.getElementsByClass(value).first().html();
			break;
		case TAG:
			content = doc.getElementsByTag(value).first().html();
			break;
		default:
			break;
		}
		return content;
	}
}
