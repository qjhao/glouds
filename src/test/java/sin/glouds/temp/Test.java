package sin.glouds.temp;

import java.io.IOException;

import org.jsoup.Jsoup;

public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println(Jsoup.connect("http://www.rushuwu.com/allvote-1.html").get().html());
	}
}
