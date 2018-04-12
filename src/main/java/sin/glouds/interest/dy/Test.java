package sin.glouds.interest.dy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sin.glouds.entity.sins.Movie;
import sin.glouds.util.StringUtil;

public class Test {

	private static List<Movie> movies = new ArrayList<>();
	private static ExecutorService service = Executors.newFixedThreadPool(10);
	private static String baseUrl = "http://www.ygdy8.net";
	private static String url = "http://www.ygdy8.net/html/gndy/dyzz/list_23_1.html";

	public static void main(String[] args) throws IOException {
		Document document = Jsoup.connect(url).get();
		for (Element element : document.getElementsByClass("co_content8").first().getElementsByTag("table")) {
			Elements elements = element.getElementsByTag("td");
			Element element2 = elements.get(2).getElementsByTag("a").first();
			if(element2.attr("href").startsWith("/html/gndy/")) {
				Movie movie = new Movie();
				movie.setName(element2.text());
				movie.setRescheduleDate(elements.get(4).text());
				movie.setDesc(elements.get(5).text());
				service.submit(new MyThread(movie, element2.attr("href")));
			}
		}
	}

	public static class MyThread implements Runnable {
		
		private Movie movie;
		private String href;
		
		public MyThread(Movie movie, String href) {
			this.movie = movie;
			this.href = href;
		}
		
		public void run() {
			service.submit(new Runnable() {
				
				@Override
				public void run() {
					try {
						Document document = Jsoup.connect(baseUrl + href).get();
						String url = document.getElementsByAttributeValue("style", "WORD-WRAP: break-word").first()
								.getElementsByTag("a").first().attr("href");
						if (StringUtil.isNotEmpty(url)) {
							movie.setUrl(url);
							movie.setCreateDate(new Date());

							movies.add(movie);
							System.out.println(movie);
						} else {
							System.out.println("未获取到地址信息");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	public static void test(String href) throws IOException {
		Document document = Jsoup.connect(baseUrl + href).get();
		String url = document.getElementsByAttributeValue("style", "WORD-WRAP: break-word").first()
				.getElementsByTag("a").first().attr("href");
		if (StringUtil.isNotEmpty(url)) {
			Movie movie = new Movie();
			movie.setUrl(url);
			movie.setCreateDate(new Date());

			Element element = document.getElementById("Zoom").getAllElements().get(1).getAllElements().get(1);
			String[] strs = element.html().replaceAll("&middot;", "·").replace("<br>◎", "<br>◎◎").split("<br>◎");
			String desc = "";
			for (String str : strs) {
				if (StringUtil.isNotEmpty(str) && !str.startsWith("<i")) {
					desc = desc + str + "\n";
				}
			}
			movie.setDesc(desc);
			movies.add(movie);
			System.out.println(movie);
		} else {
			System.out.println("未获取到地址信息");
		}
	}

}
