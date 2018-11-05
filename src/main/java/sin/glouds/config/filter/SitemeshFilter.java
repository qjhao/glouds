package sin.glouds.config.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

//@Configuration
public class SitemeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/WEB-INF/sitemesh/default.jsp")
			.addExcludedPath("/static/*")
			.addExcludedPath("/common/*")
			.addExcludedPath("/WEB-INF/sitemesh/*");
	}
}
