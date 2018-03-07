package sin.glouds.interest.buildnovel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import sin.glouds.jdao.connector.JConnector;

public class NovelBuilder {

	public static void main(String[] args) throws SQLException, IOException {
		build(10243);
	}
	
	public static void build(int id) throws SQLException, IOException {
		ResultSet result = JConnector.preparedStatement("select * from novel where id = " + id).executeQuery();
		if(result.next()) {
			String path = result.getString("path");
			path = path.endsWith(".txt")?path:path+".txt";
			ResultSet rs = JConnector.preparedStatement("select * from novel_chapter where novel_id = " + id + " order by chapter_index").executeQuery();
			PrintWriter writer = new PrintWriter(new FileWriter(new File(path)));
			while(rs.next()) {
				writer.println(rs.getString("title") + "\n" + rs.getString("content") + "\n");
			}
			writer.flush();
			writer.close();
		}
	}
}
