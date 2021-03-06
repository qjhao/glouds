package sin.glouds.temp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws IOException {
		 lukeMsg(60, 5, "超");

//		 BufferedReader reader = new BufferedReader(new FileReader(new
//		 File("H:/temp/json.txt")));
//		 String data = "",line = null;
//		 while((line = reader.readLine()) != null) {
//		 data = data + line;
//		 }
//		 JsonGen.jsonToJavaBeanFile(data, new File("H:/temp/gen/"),
//		 "TransferData", "com.thinkgem.jeesite.kingdee.bean.transfersave");

	}

	public static void lukeMsg(int ncount, int ecount, String ename) {
		ncount = ncount + ecount * 34;
		showTime(ncount, 170, ename + "5达成！！", 11, 4);
		System.out.println();
		showTime(ncount, 295, "圣耀到手！！", 11, 4);
		System.out.println();
		showTime(ncount, 595, "卢克毕业！！", 11, 4);
		System.out.println();
		System.out.println("欧皇附体！！！！！");
		showTime(0, 570, "真·欧皇成就达成！！", 11, 4);
	}

	private static void showTime(int count, int goal, String message, int max, int min) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int minWeeks = getWeeks(count, goal, max);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		calendar.add(Calendar.DAY_OF_YEAR, (minWeeks - 1) * 7);
		String nice = sdf.format(calendar.getTime());
		int maxWeeks = getWeeks(count, goal, min);
		calendar.setTime(new Date());
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		calendar.add(Calendar.DAY_OF_YEAR, (maxWeeks - 1) * 7);
		String shit = sdf.format(calendar.getTime());
		System.out.println("最早：" + nice);
		System.out.println("最晚：" + shit);
		System.out.println(message);
	}

	private static int getWeeks(int count, int goal, int per) {
		double weeks = (goal - count) / 2.0 / per;
		int actualWeeks = (int) Math.ceil(weeks);
		return actualWeeks;
	}
}
