package sin.glouds.util.check;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	@CheckElement(type = CheckElement.TYPE_LIST, length = 50, nullable = false, regex = "[\\w]+")
	private List<Tesst> tessts = new ArrayList<Tesst>();
	
	@CheckElement(type = CheckElement.TYPE_FIELD, length = 20, nullable = false, regex = "[\\w]+", name = "格鲁斯")
	private String name = "glouds";
	
	@CheckElement(type = CheckElement.TYPE_FIELD, nullable = false)
	private Double age = 23.0;
	
	@CheckElement(type = CheckElement.TYPE_OBJECT, nullable = true)
	private Tesst tesst;
	
	public static void main(String[] args) throws Exception {
		Test test = new Test();
		test.addElement();
		System.out.println(CheckUtil.check(test, test.getClass()));
	}
	public void addElement() {
		for(int i = 0; i<22; i++) {
			tessts.add(new Tesst("第"+i+"个Tesst"));
		}
	}
}

class Tesst {
	
	@CheckElement(length = 17)
	private String code = "code";
	
	public Tesst(String name) {
		code = name;
	}
}
