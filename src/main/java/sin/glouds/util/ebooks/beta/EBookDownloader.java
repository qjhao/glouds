package sin.glouds.util.ebooks.beta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import junit.framework.Assert;
import sin.glouds.util.StringUtil;

@SuppressWarnings("deprecation")
public class EBookDownloader implements EBookInterface {

	protected EBookListener listener;
	protected String url, baseUrl, filterValue, name, filePath;
	protected FilterType type;
	protected ExecutorService service = Executors.newFixedThreadPool(10);
	protected EBookDownloader downloader;
	protected int index;

	public EBookDownloader(String name, String filePath, String url, String baseUrl, FilterType type, String value,
			EBookListener listener) {
		this.name = name;
		this.filePath = filePath;
		this.url = url;
		this.baseUrl = baseUrl;
		this.type = type;
		this.filterValue = value;
		this.listener = listener;
		if(this.listener == null)
			this.listener = new EBookAdapter() {
			};
		this.downloader = this;
		listener.onTaskCreateed(this, name);
	}

	public void startTask() {
		listener.onStartTask(this);
	}

	public Chapters getChapterEntries() {
		return getChapterEntries(url);
	}

	@Override
	public Chapters getChapterEntries(String url) {
		Assert.assertNotNull("URL 不能为空", url);
		Assert.assertFalse("URL 不能为空", url == "");

		Chapters chapters = new Chapters();
		listener.onChapterDownloadStarted(this, name, chapters);
		try {
			Document doc = Jsoup.connect(url).get();
			for (Element element : doc.getElementsByTag("a")) {
				if (StringUtil.isNotEmpty(element.attr("href")) && StringUtil.isNotEmpty(element.text())
						&& element.attr("href").endsWith(".html") && (element.attr("href").startsWith("/") || StringUtil
								.isNumber(element.attr("href").substring(0, element.attr("href").indexOf("."))))) {
					chapters.add(new Chapter(element.attr("href"), element.text()));
				}
			}
		} catch (IOException e) {
			if (e instanceof UnknownHostException || e instanceof ConnectException) {
				try {
					Document doc = Jsoup.connect(url).get();
					for (Element element : doc.getElementsByTag("a")) {
						if (StringUtil.isNotEmpty(element.attr("href")) && StringUtil.isNotEmpty(element.text())
								&& element.attr("href").endsWith(".html")
								&& (element.attr("href").startsWith("/") || StringUtil.isNumber(
										element.attr("href").substring(0, element.attr("href").indexOf("."))))) {
							chapters.add(new Chapter(element.attr("href"), element.text()));
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				e.printStackTrace();
			}
		}
		listener.onChapterDownloadFinished(this, name, chapters);
		return chapters;
	}

	public Contents getContents(Chapters chapters) {
		return getContents(chapters, baseUrl, type, filterValue);
	}

	@Override
	public Contents getContents(Chapters chapters, String url, FilterType type, String filterValue) {
		Assert.assertNotNull("章节目录不能为空", chapters);
		Assert.assertFalse("章节目录不能为空", chapters.size() == 0);
		Assert.assertNotNull("URL 不能为空", url);
		Assert.assertFalse("URL 不能为空", url == "");

		Contents contents = new Contents();
		listener.onBeforeDownloading(this, name, contents);
		index = 0;
		final int size = chapters.size();
		for (Chapter chapter : chapters) {
			service.submit(new Runnable() {

				@Override
				public void run() {
					int i = increase();
					contents.add(new Content(i, getContent(chapter, url, type, filterValue)));
					listener.onDownloading(downloader, i, size, name);
				}
			});
		}
		return contents;
	}

	public void write(Contents contents) {
		try {
			File file = new File(filePath);
			if (file.exists() && file.isDirectory()) {
				write(new File(filePath, name.endsWith(".txt")?name:(name+".txt")), contents);
			} else {
				throw new FileNotFoundException("filepath should be a folder");
			}
		} catch (FileNotFoundException e) {
			listener.onError(downloader, e);
		}
	}

	@Override
	public void write(File file, Contents contents) {
		Assert.assertNotNull("内容不能为空", contents);
		Assert.assertFalse("内容不能为空", contents.size() == 0);
		Assert.assertNotNull("输出文件不能为空", file);
		listener.onBeforeWrite(this);
		try {
			contents.sort((a, b) -> a.getId() - b.getId());
			PrintWriter writer = new PrintWriter(new FileOutputStream(file));
			for (Content content : contents) {
				writer.println(content.getContent());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		listener.onAfterWrite(this, file.getAbsolutePath(), file.length());
		listener.onFinish(downloader);
	}

	@Override
	public String format(String content) {
		return content.replaceAll("<br>&nbsp;&nbsp;&nbsp;&nbsp;", "  ")
				.replaceAll("<br> &nbsp;&nbsp;&nbsp;&nbsp;", "  ").replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;", "  ")
				.replaceAll("<br>", "").replaceAll("\n\n", "\n") + "\n";
	}

	protected String getContent(Chapter chapter, String url, FilterType type, String filterValue) {
		try {
			Document doc = Jsoup.connect(url + chapter.url).get();
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
			return (chapter.title + "\n" + format(content));
		} catch (Exception e) {
			if (e instanceof UnknownHostException || e instanceof ConnectException) {
				try {
					Document doc = Jsoup.connect(url + chapter.url).get();
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
					return (chapter.title + "\n" + format(content));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				System.out.println("出错了");
			}
		}
		return "";
	}

	protected String getHtml(Chapter chapter, String url) {
		try {
			return Jsoup.connect(url + chapter.url).get().html();
		} catch (IOException e) {
			try {
				return Jsoup.connect(url + chapter.url).get().html();
			} catch (IOException e1) {
				return "获取失败";
			}
		}
	}

	synchronized int increase() {
		synchronized (this) {
			return ++index;
		}
	}
}
