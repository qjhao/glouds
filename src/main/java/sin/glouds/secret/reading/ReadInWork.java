package sin.glouds.secret.reading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import sin.glouds.util.FileUtil;
import sin.glouds.util.ebooks.alpha.EBookAdapter;
import sin.glouds.util.ebooks.alpha.Entries;
import sin.glouds.util.ebooks.alpha.Entry;

public class ReadInWork extends EBookAdapter {

	public static final String dfbb = "http://www.23us.so/files/article/html/13/13227/index.html";
	public static final String rushuwu = "http://www.rushuwu.com";
	public static final String gbxw = "http://www.63xs.com/book/0/2/";
	public static final String gbxwb = "http://www.63xs.com";
	public static final String erlang = "http://www.80txt.com/txtml_73924.html";
	public static final String yaozun = "http://www.773buy.com/101_101749/";
	public static final String qqzx = "https://www.ybdu.com/xiaoshuo/18/18982/";
	public static final String kn = "http://www.miaobige.com/read/9297/";
	public static final String fjwd = "http://www.zanghaihuatxt.com/0_421/";
	public static final String fjwdb = "http://www.zanghaihuatxt.com";
	public static final String xuzhu = "http://www.xs1002.com/biquge43/116396/";
	public static final String xuzhub = "http://www.xs1002.com";
	public static final String temp = "http://www.rushuwu.com/2/2821/";
	public static final String xiaoyao = "http://www.qu.la/book/27962/";
	public static final String xiaoyaob = "http://www.qu.la";
	public static final String cssh = "http://www.x23us.com/html/27/27936/";
	public static final String zhengfu = "http://www.rushuwu.com/0/667/";
	public static final String xcbyjzh = "http://www.x23us.com/html/9/9375/";
	public static final String fqzzqsh = "https://www.23us.la/html/80/80724/";
	public static final String fqzzqshb = "https://www.23us.la";
	public static final String erlang2 = "http://www.shenpinwu.com/14/14615/";
	public static final String erlang2b = "http://www.shenpinwu.com";
	public static final String z2bkm = "http://www.wenxuem.com/book/81/81029/";
	public static final String z2bkmb = "";
	public static final String wushi = "http://www.shenpinwu.com/5/5244/";
	public static final String shenpin = "http://www.shenpinwu.com";
	public static final String dashaoye = "http://www.shenpinwu.com/15/15142/";
	public static final String xiyou5000 = "http://www.shenpinwu.com/5/5355/";
	public static final String lzjx = "http://www.shenpinwu.com/0/37/";
	public static final String rdzs = "http://www.biquge.info/1_1359/";
	public static final String zqkkx = "http://www.shenpinwu.com/7/7569/";
	public static final String faye = "http://www.shenpinwu.com/12/12302/";
	public static final String cszyqyd = "http://www.shenpinwu.com/9/9536/";
	public static final String mrhl = "http://www.shenpinwu.com/8/8643/";
	public static final String hlyh = "https://www.23us.cc/html/7/7579/";
	public static final String hlzjz = "https://www.kuaiyankanshu.net/691634/dir.html";
	public static final String hlzjzb = "https://www.kuaiyankanshu.net";
	public static final String hlzxhzfdj = "https://www.xs74.com/novel/honglouzhixiaohuangzifendouji/";
	public static final String cfwljhg = "http://www.shenpinwu.com/18/18962/";
	public static final String hyzmnry = "https://www.qisuu.la/du/29/29417/";
	public static final String hhzntyd = "https://www.boluoxs.com/biquge/0/71/";
	public static final String hyzxd = "https://www.shenpinwu.com/1/1874/";
	public static final String hlzxhzjz = "https://www.fpzw.com/xiaoshuo/86/86637/";

	public static void main(String[] args) throws Exception {
		ReadInWork riw = new ReadInWork();
		riw.readAutoIncrease(hlzxhzjz, hlzxhzjz, -1);
	}

	public void readAutoIncrease(String url, String baseUrl, int i) throws Exception {
		int index = i;
		if (i < 0) {
			BufferedReader reader = new BufferedReader(
					new FileReader(FileUtil.createFileInUserHome("/readInWork/", "1")));
			index = Integer.parseInt(reader.readLine());
			if (i < -1)
				index -= 1;
			reader.close();
		}
		Entries entries = getChapterEntries(url);
		if (entries.size() > index) {
			Entry entry = entries.get(index);
			String content = getHtml(entry, baseUrl).replaceAll("&nbsp;", "").replaceAll("<br>", "\n");
			System.out.println((content.length() < 100000 ? content : content.substring(0, 100000)) + "\n" + index + " "
					+ entry.title);

			PrintWriter writer = new PrintWriter(FileUtil.createFileInUserHome("/readInWork/", "1"));
			writer.write(index + 1 + "");
			writer.close();
		} else {
			System.out.println(entries.size() + "/" + index + " 少年呦！青春是不允许越界的！！");
		}

	}

}
