package sin.glouds.interest.dingdian;

import java.io.IOException;

/**
 * 访问次数限制
 * @author SAMSUNG
 *
 */
public class Test {

	private static String url = "http://www.23us.com/quanben/";
	public static void main(String[] args) throws IOException {
		new DdTask().start(url, "", 793);
	}
}
