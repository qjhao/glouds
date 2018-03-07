//package sin.glouds.test.test4g;
//
//import java.time.ZoneId;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Objects;
//import java.util.Set;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Predicate;
//
//import org.json.JSONObject;
//
//import sin.glouds.bean.Order;
//import sin.glouds.util.JsonParserUtil;
//
//
//public class Java8Test {
//	public static void main(String[] args) {
//		String message = "{'orders':{'buyer_account':'123','buyer_phone':'asd'}}";
//		List<Object> orders = JsonParserUtil.parserJsonArray(message, Order.class);
//		for(Object object : orders) {
//			Order order = (Order)object;
//			System.out.println(order.buyer_account);
//			System.out.println(order.buyer_phone);
//		}
//	}
//
//	@SuppressWarnings("unused")
//	private static JSONObject getJSON(String message) {
//		// TODO Auto-generated method stub
//		return new JSONObject(message);
//	}
//	
//	public static void zoneTest() {
//		Set<String> ids = ZoneId.getAvailableZoneIds();
//		List<String> idss = new ArrayList<>();
//		idss.addAll(ids);
//		Collections.sort(idss);
//		
//		idss.stream().sorted().forEach(System.out::println);
//	}
//	
//	@SuppressWarnings("unused")
//	public static void predicateTest() {
//		
//		Predicate<String> predicate = (s) -> s.length() > 0;
//		System.out.println(predicate.test("foo"));
//		System.out.println(predicate.negate().test("foo"));
//		
//		Predicate<Boolean> nonNull = Objects::nonNull;
//		Predicate<Boolean> isNull = Objects::isNull;
//		
//		Predicate<String> isEmpty = String::isEmpty;
//		Predicate<String> isNotEmpty = isEmpty.negate();
//		
//		System.out.println(predicate.and(isEmpty).test("a"));
//	}
//	public static void streamTest() {
//		int max = 1000000;
//		List<String> values = new ArrayList<>(max);
//		for (int i = 0; i < max; i++) {
//		    UUID uuid = UUID.randomUUID();
//		    values.add(uuid.toString());
//		}
//		long t0 = System.nanoTime();
//		long count = values.parallelStream().sorted().count();
//		System.out.println(count);
//		long t1 = System.nanoTime();
//		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//		System.out.println(String.format("sequential sort took: %d ms", millis));
//	}
//}
