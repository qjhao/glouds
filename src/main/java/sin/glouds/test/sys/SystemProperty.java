package sin.glouds.test.sys;

public class SystemProperty {

	public static void main(String[] args) {
		System.getProperties().keySet()
				.forEach(obj -> System.out.println(obj.toString() + "\t" + System.getProperty(obj.toString())));
	}
}
