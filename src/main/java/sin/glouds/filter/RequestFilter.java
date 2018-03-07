package sin.glouds.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/*")
public class RequestFilter implements Filter {

	private static Logger logger = Logger.getGlobal();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void destroy() {
		logger.info("销毁RequestFilter过滤器");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		
		String url = request.getRequestURI();
		String addr = request.getRemoteAddr();
		String session = request.getRequestedSessionId();
		
		System.out.println();
		System.out.println();
		System.out.println("=======================================");
		System.out.println("请求来源：" + addr);
		System.out.println("请求地址：" + url);
		System.out.println("会话ID：" + session);
		System.out.println("请求时间：" + sdf.format(new Date()));
		
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("创建RequestFilter过滤器");
	}

}
