package sin.glouds.test.freemarker;

import java.io.IOException;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

public class FreeMarkarDemo {

	public static void main(String[] args)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_20);
		configuration.setTemplateLoader(new ClassTemplateLoader(FreeMarkarDemo.class, "/templates/freemarker/"));
		configuration.setDefaultEncoding("UTF-8");
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		configuration.setCacheStorage(NullCacheStorage.INSTANCE);
		Template template = configuration.getTemplate("helloTemplates.html");
		System.out.println(template.toString());
	}
}
