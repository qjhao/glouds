package sin.stock.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
			data.keySet().stream().sorted().forEach(obj -> writer.println(obj + " : " + data.get(obj).hashCode() + " " + data.get(obj).size()));
			writer.println("----------------打印数据结束-------------------------");
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
