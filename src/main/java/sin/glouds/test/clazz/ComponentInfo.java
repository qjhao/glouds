package sin.glouds.test.clazz;

public class ComponentInfo {

	public static void main(String[] args) {
		String[] strs = new String[3];
		System.out.println(strs.getClass().getName());
		System.out.println(strs.getClass().getComponentType().getName());
	}
}
