package sin.glouds.temp;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroTest {

	public static void main(String[] args) {
		Subject user = SecurityUtils.getSubject();
		System.out.println(user.isAuthenticated());
	}
}
