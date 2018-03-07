package sin.glouds.util.ebooks.alpha;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import junit.framework.Assert;
import sin.glouds.util.StringUtil;

@SuppressWarnings("deprecation")
public class EBookAdapter implements EBookListener {

	@Override
	public List<Entry> getEntries(String url) {
		Assert.assertNotNull("URL 不能为空", url);
		Assert.assertFalse("URL 不能为空", url == "");
		
		System.out.println("准备。。。");
		List<Entry> entries = new ArrayList<>();
		
		try{
			Document doc = Jsoup.connect(url).get();
			for(Element element : doc.getElementsByTag("a")) {
				if(StringUtil.isNotEmpty(element.attr("href")) 
						&& StringUtil.isNotEmpty(element.text()) 
						&& element.attr("href").endsWith(".html") 
						&& (element.attr("href").startsWith("/") 
						|| StringUtil.isNumber(element.attr("href").substring(0, element.attr("href").indexOf("."))))) {
					entries.add(new Entry(element.attr("href"), element.text()));
				}
			}
		}catch(IOException e) {
			if(e instanceof UnknownHostException || e instanceof ConnectException) {
				try{
					Document doc = Jsoup.connect(url).get();
					for(Element element : doc.getElementsByTag("a")) {
						if(StringUtil.isNotEmpty(element.attr("href")) 
								&& StringUtil.isNotEmpty(element.text()) 
								&& element.attr("href").endsWith(".html") 
								&& (element.attr("href").startsWith("/") 
								|| StringUtil.isNumber(element.attr("href").substring(0, element.attr("href").indexOf("."))))) {
							entries.add(new Entry(element.attr("href"), element.text()));
						}
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}else {
				e.printStackTrace();
			}
		}
		return entries;
	}
	
	public Entries getChapterEntries(String url) {
		Assert.assertNotNull("URL 不能为空", url);
		Assert.assertFalse("URL 不能为空", url == "");
		
		System.out.println("准备。。。");
		Entries entries = new Entries();
		
		try{
			Document doc = Jsoup.connect(url).get();
			for(Element element : doc.getElementsByTag("a")) {
				if(StringUtil.isNotEmpty(element.attr("href")) 
						&& StringUtil.isNotEmpty(element.text()) 
						&& element.attr("href").endsWith(".html") 
						&& (element.attr("href").startsWith("/") 
						|| StringUtil.isNumber(element.attr("href").substring(0, element.attr("href").indexOf("."))))
						|| hasEntry(element.attr("href"))) {
					entries.add(new Entry(element.attr("href"), element.text()));
				}
			}
		}catch(IOException e) {
			if(e instanceof UnknownHostException || e instanceof ConnectException) {
				try{
					Document doc = Jsoup.connect(url).get();
					for(Element element : doc.getElementsByTag("a")) {
						if(StringUtil.isNotEmpty(element.attr("href")) 
								&& StringUtil.isNotEmpty(element.text()) 
								&& element.attr("href").endsWith(".html") 
								&& (element.attr("href").startsWith("/") 
								|| StringUtil.isNumber(element.attr("href").substring(0, element.attr("href").indexOf("."))))) {
							entries.add(new Entry(element.attr("href"), element.text()));
						}
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}else {
				e.printStackTrace();
			}
		}
		return entries;
	}

	@Override
	public List<String> getContents(List<Entry> entries, String url, FilterType type, String filterValue) {
		Assert.assertNotNull("章节目录不能为空", entries);
		Assert.assertFalse("章节目录不能为空", entries.size() == 0);
		Assert.assertNotNull("URL 不能为空", url);
		Assert.assertFalse("URL 不能为空", url == "");
		
		System.out.println("开始下载。。。");
		List<String> contents = new ArrayList<>();
		int index = 1;
		int size = entries.size();
		for(Entry entry : entries) {
			System.out.println("下载中  " + ((index++ * 100) / size) + "%");
			contents.add(getContent(entry, url, type, filterValue));
		}
		System.out.println("下载完成");
		return contents;
	}

	@Override
	public void write(File file, List<String> contents) {
		Assert.assertNotNull("内容不能为空",contents);
		Assert.assertFalse("内容不能为空", contents.size() == 0);
		Assert.assertNotNull("输出文件不能为空", file);
		
		System.out.println("开始写入文件");
		
		try{
			PrintWriter writer = new PrintWriter(new FileOutputStream(file));
			for(String content : contents) {
				writer.println(content);
			}
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("文件写入完成，文件地址为：" + file.getAbsolutePath() + ", 文件大小为：" + (file.length() / 1024) + " KB");
	}

	@Override
	public String format(String content) {
		return content
				.replaceAll("<br>&nbsp;&nbsp;&nbsp;&nbsp;", "\n    ")
				.replaceAll("<br> &nbsp;&nbsp;&nbsp;&nbsp;", "\n    ")
				.replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;", "    ")
				.replaceAll("<br>", "\n") + "\n";
	}
	
	protected String getContent(Entry entry, String url, FilterType type, String filterValue) {
		try{
			Document doc = Jsoup.connect(url + entry.url).get();
			String content = "";
			switch (type) {
			case ID:
				content = doc.getElementById(filterValue).html();
				break;
			case CLASS:
				content = doc.getElementsByClass(filterValue).first().html();
				break;
			default:
				break;
			}
			return content;//format(content);
		}catch(Exception e) {
			if(e instanceof UnknownHostException || e instanceof ConnectException) {
				try{
					Document doc = Jsoup.connect(url + entry.url).get();
					String content = "";
					switch (type) {
					case ID:
						content = doc.getElementById(filterValue).html();
						break;
					case CLASS:
						content = doc.getElementsByClass(filterValue).first().html();
						break;
					default:
						break;
					}
					return content;//format(content);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}else {
				System.out.println("获取章节内容失败:" + e.getMessage());
			}
		}
		return "";
	}
	
	protected String getHtml(Entry entry, String url) throws Exception {
		if(StringUtil.isEmpty(url) && !entry.url.startsWith("http"))
			return "url格式错误: " + url + entry.url;
		try {
			return Jsoup.connect(url + entry.url).timeout(5000).get().html();
		} catch (IOException e) {
			try {
				return Jsoup.connect(url + entry.url).timeout(10000).get().html();
			} catch (IOException e1) {
				throw new IOException("获取失败 " + e1.getMessage() + " " + url + entry.url);
			}
		}
	}
	
	protected String getHtml(String url) {
		try {
			return Jsoup.connect(url).get().html();
		} catch (IOException e) {
			try {
				return Jsoup.connect(url).get().html();
			} catch (IOException e1) {
				return "获取失败";
			}
		}
	}
	
	private static boolean hasEntry(String url) {
		if(url.contains("/") && url.contains(".") && url.lastIndexOf("/") < url.lastIndexOf("."))
			return StringUtil.isNumber(url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")));
		return false;
	}
	
}
