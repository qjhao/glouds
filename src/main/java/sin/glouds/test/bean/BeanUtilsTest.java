package sin.glouds.test.bean;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsTest {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Demo demo = new Demo();
		demo.setName("Glouds");
		demo.setAge(26);
		Demo result = new Demo();
		BeanUtils.copyProperty(result, "Name", demo);
		System.out.println(result.getName());
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

	public void setAge(Integer age) {
		this.age = age;
	}

}
