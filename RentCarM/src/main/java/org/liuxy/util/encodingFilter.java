package org.liuxy.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class encodingFilter
 */
@WebFilter("/*")
public class encodingFilter implements Filter {
	
	private String ENCODE = "UTF-8";
	
    /**
     * Default constructor. 
     */
    public encodingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		
		request.setCharacterEncoding(ENCODE);
		response.setContentType("text/html;charset="+ ENCODE);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// ENCODE = fConfig.getInitParameter("CharSet");
	}

}
