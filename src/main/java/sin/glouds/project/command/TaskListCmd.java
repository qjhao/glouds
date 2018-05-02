package sin.glouds.project.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskListCmd {

	public static void main(String[] args) throws IOException {
		Process process = Runtime.getRuntime().exec("tasklist");
		String line = null;
		int[] len = new int[5];
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
		line = reader.readLine();
		if(line != null)
			while ("".equals(line)){
				line = reader.readLine();
			}
		if(line != null)
			line = reader.readLine();
		if(line != null && "".equals(line.replaceAll("=", "").trim())) {
			String[] strs = line.split(" ");
			System.out.println(strs.length);
			System.out.println(line);
			System.out.println();
			if(strs.length == 5) {
				len[0] = strs[0].length();
				len[1] = strs[1].length();
				len[2] = strs[2].length();
				len[3] = strs[3].length();
				len[4] = strs[4].length();
				while((line = reader.readLine()) != null) {
					int beg = 0,end = len[0];
					System.out.println(line.substring(beg, end).trim());
					beg = end + 1;
					end = beg + len[1];
					System.out.println(line.substring(beg,end).trim());
					beg = end + 1;
					end = beg + len[2];
					System.out.println(line.substring(beg,end).trim());
					beg = end + 1;
					end = beg + len[3];
					System.out.println(line.substring(beg,end).trim());
					beg = end + 1;
					end = beg + len[4];
					System.out.println(line.substring(beg,end).trim());
					System.out.println();
				}
			}else {
				System.out.println(line);
				while((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}
		}else {
			System.out.println(line);
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
