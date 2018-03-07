package sin.glouds.util.tarenacode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;

import sin.glouds.util.ebooks.alpha.Entries;
import sin.glouds.util.ebooks.alpha.Entry;
import sin.glouds.util.tarenacode.config.Config;

public class Test {

	private static String folder = "GSDCode/gsd1704/";
	private static String baseFolder = "F://tarena/gsd1704";

	private static ExecutorService service;

	public static void main(String[] args) throws IOException {
		// System.out.println(Base64.getEncoder().encodeToString("tarenacod:ecode_2013".getBytes()));
		// System.out.println(Jsoup.connect(Config.BASE_URL).header("Authorization",
		// "Basic " +
		// Base64.getEncoder().encodeToString((Config.USERNAME+":"+Config.PASSWORD).getBytes())).get().html());
		// System.out.println(Jsoup.connect(Config.BASE_URL+folder).header("Authorization",
		// "Basic " +
		// Base64.getEncoder().encodeToString((Config.USERNAME+":"+Config.PASSWORD).getBytes())).get().html());

		// Jsoup.connect(Config.BASE_URL).header("Authorization", "Basic " +
		// Base64.getEncoder().encodeToString((Config.USERNAME+":"+Config.PASSWORD).getBytes())).get().getElementsByTag("pre").first().getElementsByTag("a").forEach(obj
		// -> {
		// System.out.println(obj.attr("href") + "\t" + obj.text());
		// });

		// String url = Config.BASE_URL + folder + "S1/day02/DAY02-0502.txt";
		// downloadFile(url);

		begin();
	}

	private static void begin() {
		File baseFile = new File(baseFolder);

		String baseUrl = Config.BASE_URL + folder;

		service = Executors.newFixedThreadPool(5);

		operate(baseUrl, baseFile);
	}

	private static void operate(String baseUrl, File baseFile) {
		service.submit(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				boolean flag = false;
				try {
					initDir(baseFile);
					for (Entry entry : parseTarena(baseUrl)) {
						if (!"../".equals(entry.url)) {
							File file = new File(baseFile, entry.title);
							if (entry.url.endsWith("/")) {
								operate(baseUrl + entry.url, file);
							} else {
								downloadFile(baseUrl + entry.url, file);
							}
						}
					}
					flag = true;
				} catch (Exception e) {
					//e.printStackTrace();
				}
				
				System.out.println("下载文件" + (flag?"成功":"失败") + ",文件名:" + baseFile + ",用时:" + ((System.currentTimeMillis() - start)/1000) + "s.");
			}
		});
	}

	private static boolean initDir(File file) {
		if (!file.exists() || file.isFile()) {
			return file.mkdirs();
		}
		return false;
	}

	private static Entries parseTarena(String url) {
		Entries entries = new Entries();

		try {
			Jsoup.connect(url)
					.header("Authorization",
							"Basic " + Base64.getEncoder()
									.encodeToString((Config.USERNAME + ":" + Config.PASSWORD).getBytes()))
					.get().getElementsByTag("pre").first().getElementsByTag("a").forEach(obj -> {
						entries.add(new Entry(obj.attr("href"), obj.text()));
					});
		} catch (Exception e) {
			if (e instanceof UnknownHostException || e instanceof ConnectException) {
				try {
					Jsoup.connect(url)
							.header("Authorization",
									"Basic " + Base64.getEncoder()
											.encodeToString((Config.USERNAME + ":" + Config.PASSWORD).getBytes()))
							.get().getElementsByTag("pre").first().getElementsByTag("a").forEach(obj -> {
								entries.add(new Entry(obj.attr("href"), obj.text()));
							});
				} catch (Exception ex) {

				}
			}
		}

		return entries;
	}

	private static boolean downloadFile(String urlStr, File file) {
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.addRequestProperty("Authorization", "Basic "
					+ Base64.getEncoder().encodeToString((Config.USERNAME + ":" + Config.PASSWORD).getBytes()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
			PrintWriter writer = new PrintWriter(file);
			String line, temp = null;
			while ((line = reader.readLine()) != null) {
				if (temp != null)
					writer.println(temp);
				temp = line;
			}
			if (temp != null)
				writer.print(temp);
			reader.close();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unused")
	private static boolean downloadFile(String urlStr) {
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.addRequestProperty("Authorization", "Basic "
					+ Base64.getEncoder().encodeToString((Config.USERNAME + ":" + Config.PASSWORD).getBytes()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
			PrintWriter writer = new PrintWriter(System.out);
			String line, temp = null;
			while ((line = reader.readLine()) != null) {
				if (temp != null)
					writer.println(temp);
				temp = line;
			}
			if (temp != null)
				writer.print(temp);
			reader.close();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
