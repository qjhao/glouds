package sin.glouds.interest.ais;

import java.io.IOException;

import org.jsoup.Jsoup;

public class Test {

	private static final String url = "http://www.23us.cc";
	public static void main(String[] args) throws IOException {
		System.out.println(Jsoup.connect(url).get().html());
	}
}
