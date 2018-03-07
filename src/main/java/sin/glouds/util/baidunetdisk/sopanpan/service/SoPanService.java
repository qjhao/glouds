package sin.glouds.util.baidunetdisk.sopanpan.service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sin.glouds.util.baidunetdisk.sopanpan.bean.Result;
import sin.glouds.util.baidunetdisk.sopanpan.bean.Results;
import sin.glouds.util.baidunetdisk.sopanpan.bean.SearchResult;
import sin.glouds.util.baidunetdisk.sopanpan.bean.SearchResults;
import sin.glouds.util.baidunetdisk.sopanpan.bean.SoPanInfo;

public class SoPanService {

	private static SearchResults search1(SoPanInfo info) throws IOException {
		Connection conn = Jsoup.connect(info.getUrl());
		SearchResults results = new SearchResults();
		Document doc = conn.timeout(300000).get();
		Elements root = doc.getElementsByClass("ulst1").first().getAllElements().get(1).getAllElements().get(1).siblingElements();
		for(Element element : root) {
			Elements elements = element.getElementsByTag("a");
			if(elements != null && elements.size() > 0) {
				results.add(new SearchResult(elements.get(0).attr("href"), elements.get(0).attr("title"), "", ""));
			}
		}
		return results;
	}
	
	public static Results search(SoPanInfo info) {
		SearchResults rs = null;
		try {
			rs = search1(info);
		} catch (IOException e) {
			if(e instanceof ConnectException || e instanceof UnknownHostException) {
				try{
					rs = search1(info);
				}catch(Exception ex) {
					
				}
			}
		}
		
		if(rs != null) {
			return search2(info, rs);
		}
		return new Results();
	}
	
	private static Results search2(SoPanInfo info, SearchResults rs) {
		Results results = new Results();
		for(SearchResult sr : rs) {
			try{
				results.add(search3(info, sr));
			} catch (IOException e) {
				if(e instanceof ConnectException || e instanceof UnknownHostException) {
					try{
						results.add(search3(info, sr));
					}catch(Exception ex) {
						
					}
				}
			}
		}
		return results;
	}
	
	private static Result search3(SoPanInfo info, SearchResult sr) throws IOException {
		Document doc = Jsoup.connect(info.getBaseUrl() + sr.getUrl()).get();
		return new Result(doc.getElementsByAttributeValue("name", "downurl").first().getElementsByTag("img").first().attr("alt"), doc.getElementsByAttributeValue("name", "downurl").first().attr("href"));
	}
}
