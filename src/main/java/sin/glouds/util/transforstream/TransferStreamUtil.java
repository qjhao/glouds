package sin.glouds.util.transforstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import sin.glouds.util.StringUtil;

/**
 * 很多地方都会使用到输入输出流，大都是从输入流读取写入到输出流，
 * 每次都写同样的代码很烦很不方便，所以写了这个工具类，
 * 
 * 接收两个输入输出流的引用，并包装成BufferedReader和PrinterWriter
 * 通过line的读写实现流的转换
 * 
 * 进行包装主要为了可以接收不同的参数，如：字符流、字节流等，并统一关闭
 * 使用者需要注意
 * 
 * 此操作为耗时操作，建议不要在主线程中使用
 * 
 * 只有传入参数为Stream是会设置编码格式，使用时可自行封装为Reader、Writer
 * 后再传入已控制编码格式，默认编码格式为UTF-8
 * 
 * @author glouds
 *
 */
public class TransferStreamUtil {

	private static BufferedReader reader;
	private static PrintWriter writer;
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static String charSet;
	private static String line;
	
	public static void transfer(Reader in, Writer out) throws IOException {
		reader = new BufferedReader(in);
		writer = new PrintWriter(out);
		write(reader, writer);
	}
	
	public static void transfer(Reader in, OutputStream out) throws IOException {
		reader = new BufferedReader(in);
		writer = new PrintWriter(new OutputStreamWriter(out, StringUtil.isEmpty(charSet) ? DEFAULT_CHARSET : charSet));
		write(reader, writer);
	}
	
	public static void transfer(InputStream in, Writer out) throws IOException {
		reader = new BufferedReader(new InputStreamReader(in, StringUtil.isEmpty(charSet) ? DEFAULT_CHARSET : charSet));
		writer = new PrintWriter(out);
		write(reader, writer);
	}
	
	public static void transfer(InputStream in, OutputStream out) throws IOException {
		reader = new BufferedReader(new InputStreamReader(in, StringUtil.isEmpty(charSet) ? DEFAULT_CHARSET : charSet));
		writer = new PrintWriter(new OutputStreamWriter(out, StringUtil.isEmpty(charSet) ? DEFAULT_CHARSET : charSet));
		write(reader, writer);
	}
	
	private static void write(BufferedReader in, PrintWriter out) throws IOException {
		while((line = in.readLine()) != null)
			out.println(line);
		out.flush();
		close();
	}
	
	private static void close() throws IOException {
		if(reader != null) {
			reader.close();
			reader = null;
		}
		if(writer != null) {
			writer.close();
			writer = null;
		}
	}
	
	public static void setCharSet(String charactor) {
		charSet = charactor;
	}
	
	public static String getCharSet() {
		return StringUtil.isEmpty(charSet) ? DEFAULT_CHARSET : charSet;
	}
}
