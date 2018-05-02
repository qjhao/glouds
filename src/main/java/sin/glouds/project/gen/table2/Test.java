package sin.glouds.project.gen.table2;

import java.util.List;

import sin.glouds.project.gen.table2.bean.ColumnInfo;
import sin.glouds.project.gen.table2.bean.DatabaseInfo;
import sin.glouds.project.gen.table2.bean.TableInfo;
import sin.glouds.project.gen.table2.util.GenUtil;

public class Test {

//	private static String filePath = "H://temp/gen/";
//	private static String packageName;

	public static void main(String[] args) throws Exception {
		// GenModel model = new GenModel();
		//
		// FreemarkerUtil.generate("test/entity.ftl", model,
		// "H://temp/User.java");
		
		long begin = System.currentTimeMillis();
		columnListTest();
		System.out.println(System.currentTimeMillis() - begin);
	}
	
	public static void columnListTest() {
		DatabaseInfo info = DatabaseInfo.Builder.mysql
				.url("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true").username("root")
				.password("1234").build();
		TableInfo tableInfo = new TableInfo("user", null);
		List<ColumnInfo> infos = GenUtil.getColumnList(info, tableInfo);
		System.out.println(infos.size());
		System.out.println(infos);
	}
	
	public static void tableListTest() {
		DatabaseInfo info = DatabaseInfo.Builder.mysql
				.url("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true").username("root")
				.password("1234").build();
		List<TableInfo> infos = GenUtil.getTableList(info);
		System.out.println(infos.size());
		System.out.println(infos);
	}
}
