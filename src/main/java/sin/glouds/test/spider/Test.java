package sin.glouds.test.spider;

import java.util.List;

import sin.glouds.test.spider.bean.LinkTypeData;
import sin.glouds.test.spider.bean.Rule;
import sin.glouds.test.spider.core.ExtractService;

public class Test {
	
	public static void main(String[] args) {
		getDatasByCssQuery();
	}

	public static void getDatasByClass() {
		Rule rule = new Rule("http://www.sxcredit.gov.cn/",
				null, null,
				"cont_right", Rule.CLASS, Rule.POST);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}

	public static void getDatasByCssQuery() {
		Rule rule = new Rule("http://www.11315.com/search", new String[] { "name" }, new String[] { "兴网" },
				"div.g-mn div.con-model", Rule.SELECTION, Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}

	public static void printf(List<LinkTypeData> datas) {
		for (LinkTypeData data : datas) {
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());
			System.out.println("***********************************");
		}

	}
}
