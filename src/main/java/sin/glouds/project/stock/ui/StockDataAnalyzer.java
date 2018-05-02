package sin.glouds.project.stock.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class StockDataAnalyzer {

	private Map<String, List<Integer>> data = new HashMap<>();
	
	private static StockDataAnalyzer analyzer = new StockDataAnalyzer();
	
	private StockDataAnalyzer() {}
	
	public static StockDataAnalyzer getInstance() {
		return analyzer;
	}
	
	public void putData(String currTime, List<Integer> currData) {
		data.put(currTime, currData);
	}
	
	public List<Integer> getData(String currTime) {
		return data.get(currTime);
	}
	
	public void printData() {
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(new File("H:/temp/stockData.txt")));
			writer.println("----------------开始打印数据-------------------------");
			data.keySet().stream().sorted().forEach(obj -> {
				List<Integer> dat = data.get(obj);
				if(dat.size() > 0)
					writer.println(obj + " : " + dat.get(0) + " - " + dat.get(dat.size() - 1));
				else 
					writer.println(obj + "并木有数据呀");
			});
			writer.println("----------------打印数据结束-------------------------");
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
