package sin.glouds.interest.zhuishushenqi;

import java.io.IOException;

import org.jsoup.Jsoup;

/**
 * 收费会员制都该死
 * @author SAMSUNG
 *
 */
public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println(Jsoup.connect("http://www.zhuishushenqi.com/category?gender=male&amp;type=hot&amp;major=41&amp;minor=&amp;page=2").get().html());
	}
}
