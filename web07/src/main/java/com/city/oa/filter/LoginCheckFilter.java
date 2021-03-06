package com.city.oa.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户登录检查过滤器
 */
@WebFilter(
		urlPatterns = { "/*"		}, 
		initParams = { 
				@WebInitParam(name = "driver", value = "driver"), 
				@WebInitParam(name = "url", value = "url")
		})
public class LoginCheckFilter implements Filter {
    
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("登录检查过滤器.....");
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String uri=req.getRequestURI();
		if(uri.contains("login")||uri.contains("error")){
			chain.doFilter(request, response);
		}
		else{
			HttpSession session=req.getSession();
			if(session.getAttribute("userid")==null){
				res.sendRedirect("login.jsp");
				
			}
			else{
				chain.doFilter(request, response);
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
