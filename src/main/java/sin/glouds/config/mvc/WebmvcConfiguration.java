package sin.glouds.config.mvc;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import sin.glouds.config.filter.SitemeshFilter;
import sin.glouds.config.interceptor.RequestInterceptor;

@Configuration
public class WebmvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/*");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/common/**").addResourceLocations("classpath:/static/common/");
		super.addResourceHandlers(registry);
	}

	@Bean
	@Order(value = 200)
	public FilterRegistrationBean sitemeshFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new SitemeshFilter());
		return bean;
	}
}
