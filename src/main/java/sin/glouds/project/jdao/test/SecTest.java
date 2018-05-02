package sin.glouds.project.jdao.test;

public class SecTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		new SinFirUserDao().save(new SinFirUser(2,"johnsin","123","asdfgh"));
	}
}
