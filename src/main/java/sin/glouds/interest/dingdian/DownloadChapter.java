package sin.glouds.interest.dingdian;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sin.glouds.jdao.connector.JConnector;
import sin.glouds.util.ebooks.alpha.EBookAdapter;
import sin.glouds.util.ebooks.alpha.Entries;
import sin.glouds.util.ebooks.alpha.Entry;
import sin.glouds.util.ebooks.alpha.FilterType;

public class DownloadChapter extends EBookAdapter {

	public static void main(String[] args) {
		try {
			ResultSet resultSet = JConnector.preparedStatement("select * from novel where id=1579").executeQuery();
			if (resultSet.next()) {
				String url = resultSet.getString("url");
				int id = resultSet.getInt("id");
				DownloadChapter dc = new DownloadChapter();
				Entries entries = dc.getChapterEntries(url);
				int index = 1;
				ExecutorService service = Executors.newFixedThreadPool(5);
				for(Entry entry : entries) {
					final int i = index++;
					service.submit(new Runnable() {
						
						@Override
						public void run() {
							String content = dc.getContent(entry, url, FilterType.ID, "contents");
							if(!"".equals(content)) {
								try {
									JConnector.preparedStatement("insert into novel_chapter (novel_id,title,content,url,chapter_index) values ('" + id + "','" + entry.title + "','" + content + "','" + url + entry.url + "','" + i + "')").executeUpdate();
									System.out.println(i + "/" + entries.size());
								} catch (SQLException e) {
									System.out.println("保存章节信息失败 index:" + i + " title" + entry.title);
								}
							}
						}
					});
				}
			}
		}catch (SQLException sqle) {
			System.out.println("获取url失败" + sqle.getMessage());
		}
	}
}
