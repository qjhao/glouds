package sin.glouds.test.test4g;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

import sin.glouds.bean.LnkFileHeader;
import sin.glouds.util.BytesUtil;

public class Test {
	private static String OWNER_ID = "98123498";

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, ClassNotFoundException, NoSuchAlgorithmException {
//		String string = "{\"order_id\":\"97a2453dea3c\",\"order_time\":\"2016-07-07 00:00:00\",\"pay_time\":\"2016-07-07 00:00:00\",\"total_amount\":\"0.01\",\"theory_wt\":\"0\",\"transport_service_code\":\"TTk\",\"receiver_province\":\"浙江\",\"receiver_city\":\"杭州市\",\"receiver_county\":\"江干区\",\"receiver_address\":\"七格小区\",\"receiver_name\":\"秦建浩\",\"receiver_mobile\":\"15990194473\",\"receiver_phone\":\"15990194473\",\"orderTotalAmount\":\"0.01\",\"orderGoodsAmount\":\"0.01\",\"orderTaxAmount\":\"0.0\",\"purchaserId\":\"546\",\"logisCompanyName\":\"TTK\",\"userProcotol\":\"\",\"senderCountry\":\"86\",\"name\":\"秦建浩\",\"telNumber\":\"15990194473\",\"payCompanyCode\":\"payCompanyCode\",\"paperType\":\"01\",\"paperNumber\":\"330825456890567012\",\"preEntryNumber\":\"HCKJ6297a2453dea3c\",\"importType\":\"1\",\"iePort\":\"xiasha\",\"destinationPort\":\"xiasha\",\"mainGName\":\"GG\",\"tradeCountry\":\"86\",\"trafMode\":\"huiji\",\"company_name\":\"hc\",\"currCode\":\"163\",\"senderName\":\"glouds\",\"GROSS_WEIGHT\":\"1\",\"worth\":\"1\",\"buyerIdType\":\"1\",\"buyerIdNumber\":\"370683\",\"buyerName\":\"glouds\",\"companyName\":\"海仓\",\"companyCode\":\"hc\",\"loigsCompanyName\":\"天天快递\",\"loigsCompanyCode\":\"TTK\",\"feeAmount\":\"0\",\"insureAmount\":\"0\",\"consigneeAddress\":\"闸弄口\",\"purchaserTelNumber\":\"12312312311\",\"inOutDateStr\":\"2016-06-06 11:11:11\",\"netWeight\":\"1\",\"order_items\":[{\"sku_id\":\"L251\",\"qty\":\"1\",\"goodsOrder\":\"23\",\"declTotalPrice\":\"0.01\",\"codeTs\":\"1234\",\"goodsUnit\":\"null\",\"originCountry\":\"86\",\"declPrice\":\"0.01\",\"firstUnit\":\"null\",\"firstCount\":\"1\",\"secondUnit\":\"se\",\"productRecordNo\":\"asd\",\"itemRecordNo\":\"asd\"}]}";
//		System.out.println(string.replaceAll("\\\"", "\""));
//		String result = WebServiceUtil.connectEPort("http://120.55.84.19:81/interface_test/", getSendStr(string.replaceAll("\\\"", "\"")).getBytes());
//		System.out.println(result);
	}
	
	public static String getSendStr(String data) throws NoSuchAlgorithmException {
		StringBuilder sb = new StringBuilder();
		MessageDigest digest = MessageDigest.getInstance("MD5");
		String sign = Base64.getEncoder().encodeToString(digest.digest((data + OWNER_ID ).getBytes()));
//		System.out.println(Base64Utils.encodeToString(digest.digest("aabb".getBytes())));
		sb.append("sign=").append(sign).append("&");
		sb.append("notify_type=").append("20").append("&");
		sb.append("notify_id=").append("opopz").append("&");
		sb.append("notify_time=").append("2016-06-06 11:11:11").append("&");
		sb.append("wms_id=").append("zwy").append("&");
		sb.append("stock_id=").append("12").append("&");
		sb.append("owner_id=").append(OWNER_ID).append("&");
		sb.append("data=").append(data);
		
		return sb.toString();
	}
	
	public static void stackTrace() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		for(StackTraceElement st : sts) {
			System.out.println(st.getClassName());
			System.out.println(st.getFileName());
			System.out.println(st.getLineNumber());
			System.out.println(st.getMethodName());
			System.out.println(st.isNativeMethod());
		}
	}
	
	public static void clock() {
		//java8
//		Clock clock = Clock.systemDefaultZone();
//		System.out.println(clock.millis());
//		System.out.println(clock.getZone());
//		System.out.println(clock.instant());
	}
	
	public static void getUUID() {
		for(int i=0;i<8;i++) {
			System.out.println(UUID.randomUUID().toString());
		}
	}
	
	public static void lnkTest() throws IOException {
		File file = new File("C://hjb/eclipse.lnk");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		LnkFileHeader lnkFileHeader = new LnkFileHeader(raf);
		System.out.println(BytesUtil.bytesToInt(lnkFileHeader.createTime, 0));
		System.out.println(BytesUtil.bytesToInt(lnkFileHeader.createTime, 4));
	}
	
	public static void stringTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Double double1 = new Double("123.45");
		Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		char[] str = (char[])field.get(double1.toString());
		System.out.println(str.length);
		for(char c : str) {
			System.out.println(c);
		}
	}
	
	
}
