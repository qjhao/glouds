package sin.glouds.test.json;

import com.google.gson.Gson;

public class GsonTest {

	private static Gson gson = new Gson();
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.setName("glouds");
		System.out.println(encode(demo));
		String json = "{\"name\":\"glouds\"}",json1 = "{\"name\":\"glouds\",\"age\":null}";
		System.out.println("---------------------");
		System.out.println(decode(json).getName());
		System.out.println("=====================");
		System.out.println(decode(json1).getName());
	}
	
	public static String encode(Demo demo) {
		return gson.toJson(demo);
	}
	
	public static Demo decode(String json) {
		return (Demo) gson.fromJson(json, Demo.class);
	}
}

class Demo {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}