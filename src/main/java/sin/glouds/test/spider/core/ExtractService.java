package sin.glouds.test.spider.core;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sin.glouds.test.spider.bean.LinkTypeData;
import sin.glouds.test.spider.bean.Rule;
import sin.glouds.test.spider.exception.IllegalRuleException;
import sin.glouds.util.ArrayUtil;
import sin.glouds.util.StringUtil;

public class ExtractService {

	public static List<LinkTypeData> extract(Rule rule) {

		validateRule(rule);

		List<LinkTypeData> datas = new ArrayList<>();
		LinkTypeData data = null;

		try {
			String url = rule.getUrl();
			String[] params = rule.getParams();
			String[] values = rule.getValues();
			String resultTagName = rule.getResultTagName();
			int type = rule.getType();
			int requestType = rule.getRequestMethod();

			Connection conn = Jsoup.connect(url);

			if (params != null)
				for (int i = 0; i < params.length; i++)
					conn.data(params[i], values[i]);

			Document doc = null;

			switch (requestType) {
			case Rule.GET:
				doc = conn.timeout(100000).get();
				break;
			case Rule.POST:
				doc = conn.timeout(100000).post();
			}

			Elements results = new Elements();

			switch (type) {
			case Rule.CLASS:
				results = doc.getElementsByClass(resultTagName);
				break;
			case Rule.ID:
				Element result = doc.getElementById(resultTagName);
				results.add(result);
				break;
			case Rule.SELECTION:
				results = doc.select(resultTagName);
				break;
			default:
				if (StringUtil.isEmpty(resultTagName))
					results = doc.getElementsByTag("body");
			}

			for (Element result : results) {
				Elements links = result.getElementsByTag("a");

				for (Element link : links) {
					String linkHref = link.attr("href");
					String linkText = link.text();

					data = new LinkTypeData();
					data.setLinkHref(linkHref);
					data.setLinkText(linkText);

					datas.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}

	private static void validateRule(Rule rule) {
		String url = rule.getUrl();
		if (StringUtil.isEmpty(url))
			throw new IllegalRuleException("URL不能为空");
		if (!url.startsWith("http://"))
			throw new IllegalRuleException("URL格式不正确");
		if (!ArrayUtil.lengthEquals(rule.getParams(), rule.getValues()))
			throw new IllegalRuleException("参数的键值对个数不匹配");
	}
}
