package sin.glouds.test.beetl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;

import sin.glouds.common.Global;

public class GroupTemplateDemo {

	public static void main(String[] args) throws IOException {
		templateVariable();
	}
	
	public static void templateVariable() throws IOException {
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("templates/beetl/test/");
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
		Template template = groupTemplate.getTemplate("/templateVariable.txt");
		String str = template.render();
		System.out.println(str);
	}

	public static void share() throws IOException {
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("templates/beetl/test/");
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
		Map<String, Object> vars = new HashMap<>();
		vars.put("prop", "beetl");
		groupTemplate.setSharedVars(vars);
		Template template = groupTemplate.getTemplate("/helloo.txt");
		template.binding("_root", new Data());
		List<String> list = Arrays.asList("glouds", "JohnSin");
		template.binding("list", list);
		String str = template.render();
		System.out.println(str);
	}

	public static void root() throws IOException {
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("templates/beetl/test/");
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
		Template template = groupTemplate.getTemplate("/hellos.txt");
		template.binding("_root", new Data());
		List<String> list = Arrays.asList("glouds", "JohnSin");
		template.binding("list", list);
		String str = template.render();
		System.out.println(str);
	}

	public static void forEach() throws IOException {
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("templates/beetl/test/");
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
		Template template = groupTemplate.getTemplate("/hellos.txt");
		template.binding("name", "world");
		List<String> list = Arrays.asList("glouds", "JohnSin");
		template.binding("list", list);
		String str = template.render();
		System.out.println(str);
	}

	public static void stringResourceLoader() throws IOException {
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("hello, ${name}");
		t.binding("name", "beetl");
		String str = t.render();
		System.out.println(str);
	}

	public static void fileResourceLoader() throws IOException {
		String root = Global.getSystemProp("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "templates" + File.separator + "beetl";
		FileResourceLoader resourceLoader = new FileResourceLoader(root, "UTF-8");
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
		Template template = groupTemplate.getTemplate("/test/hello.txt");
		template.binding("name", "world");
		String str = template.render();
		System.out.println(str);
	}

	public static void classPathResourceLoader() throws IOException {
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("templates/beetl/test/");
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
		Template template = groupTemplate.getTemplate("/hello.txt");
		template.binding("name", "world");
		String str = template.render();
		System.out.println(str);
	}

}

class Data {
	private String name = "template";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
