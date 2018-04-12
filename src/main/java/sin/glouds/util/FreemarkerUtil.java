package sin.glouds.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;
import sin.glouds.test.freemarker.FreeMarkarDemo;

public final class FreemarkerUtil {

	private FreemarkerUtil() {}
	public static FreemarkerUtil instance = new FreemarkerUtil();
	private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_20);
	
	public static final String TEMPLATES_PATH_TEST = "/templates/freemarker/test";
	
	static {
		configuration.setTemplateLoader(new ClassTemplateLoader(FreemarkerUtil.class, "/templates/freemarker/"));
		configuration.setDefaultEncoding("UTF-8");
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		configuration.setCacheStorage(NullCacheStorage.INSTANCE);
	}
	
	public static Configuration getConfiguration() {
		return configuration;
	}
	
	public static Template getTemplate(String name) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		return configuration.getTemplate(name);
	}
	
	public static void generate(Template template, Object model, Writer writer) throws TemplateException, IOException {
		template.process(model, writer);
	}
	
	public static void generate(String templateName, Object model, Writer writer) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		generate(getTemplate(templateName), model, writer);
	}
	
	public static void generate(String templateName, Object model, File file) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		generate(templateName, model, new FileWriter(file));
	}
	
	public static void generate(String templateName, Object model, String fileName) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		generate(templateName, model, new FileWriter(fileName));
	}
	
	public static void setTemplatePath(String path) {
		configuration.setTemplateLoader(new ClassTemplateLoader(FreeMarkarDemo.class, path));
	}
	
	public static String getTemplatePath() {
		return configuration.getTemplateLoader().toString();
	}
	
	public static void main(String[] args) throws Exception {
		Map<String, String> model = new HashMap<>();
		model.put("title", "hello templates");
		model.put("content", "Hello Freemarker!!");
		generate("helloTemplates.html", model, "H://temp/helloTemplates.html");
	}
}
