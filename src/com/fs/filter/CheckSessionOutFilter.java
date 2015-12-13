package com.fs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fs.entity.User;

public class CheckSessionOutFilter implements Filter {
	protected FilterConfig filterConfig = null;

	/**
	 * Take this filter out of service.
	 */
	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsrq = (HttpServletRequest) request;
		HttpServletResponse hsrp = (HttpServletResponse) response;
		String reqPage = hsrq.getServletPath();
		System.out.println("reqPage:::"+reqPage);
//		if(!reqPage.trim().equals("/login")) {
//			UserBasinfo userinfo = (UserBasinfo) hsrq.getSession().getAttribute(Constant.SESSION_USER);
//			if (userinfo == null || "".equals(userinfo.getLOG_NAME())) {
//				hsrp.sendRedirect("login");
//				return;
//			}
//		}
		//包含/user路径的 需要验证是否登陆
		if(reqPage.trim().startsWith("/user")){
			User userinfo = (User) hsrq.getSession().getAttribute("USER");
			if (userinfo == null) {
				hsrp.sendRedirect("../login");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
}
