//package sin.glouds.test.redis;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import redis.clients.jedis.Jedis;
//
//public class JedisTest {
//
//	private static Jedis jedis;
//	private static String server = "localhost";
//	
//	public static void main(String[] args) {
////		saveString("name", "glouds");
////		saveStringList("names", "glouds","johnsin","qjhao","qinjh");
////		jedis.save();
////		System.out.println(jedis.type("name"));
////		System.out.println(jedis.type("names"));
//		System.out.println(getString("name"));
//		System.out.println(getString("names"));
//		System.out.println(getStringList("names").size());
//	}
//	
//	public static void saveString(String key, String value) {
//		getJedis().set(key, value);
//	}
//	
//	public static void saveStringIfNotExists(String key, String value) {
//		if(!getJedis().exists(key))
//			getJedis().set(key, value);
//	}
//	
//	public static String getString(String key) {
//		return getString(key, "");
//	}
//	
//	public static String getString(String key, String defaultValue) {
//		if(getJedis().exists(key)) {
//			if(!getJedis().type(key).equals("string"))
//				return null;
//			return getJedis().get(key);
//		}
//		return defaultValue;
//	}
//	
//	public static void saveStringList(String key, List<String> values) {
//		getJedis().lpush(key, (String[])values.toArray());
//	}
//	
//	public static void saveStringList(String key, String ... values) {
//		getJedis().lpush(key, values);
//	}
//	
//	public static List<String> getStringList(String key) {
//		List<String> list = new ArrayList<>();
//		list.addAll(getJedis().lrange(key, 0, getJedis().llen(key) - 1));
//		return list;
//	}
//	
//	public static List<String> getBeginOfStringList(String key, long lengthOfBegin) {
//		List<String> list = new ArrayList<>();
//		long length = getJedis().llen(key) - 1;
//		list.addAll(getJedis().lrange(key, 0, (length > lengthOfBegin ? lengthOfBegin : length)));
//		return list;
//	}
//	
//	public static List<String> getEndOfStringList(String key, long lengthOfEnd) {
//		List<String> list = new ArrayList<>();
//		long length = getJedis().llen(key) - 1;
//		list.addAll(getJedis().lrange(key, 0, (length > lengthOfEnd ? lengthOfEnd : length)));
//		return list;
//	}
//	
//	private static Jedis getJedis() {
//		if(jedis == null)
//			jedis = new Jedis(server);
//		return jedis;
//	}
//	
//	public static void setServer(String ip) {
//		server = ip;
//	}
//}
