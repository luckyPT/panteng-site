package com.site.panteng.filter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.http.HttpRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created by panteng on 2017/4/8.
 */
public class MyFilter extends OncePerRequestFilter {
    private static Logger logger = Logger.getLogger(MyFilter.class);
    static {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/target/classes/log4j.properties");
    }
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        logger.info("myFilter 拦截成功... .." + httpServletRequest.getRemoteAddr());
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("panteng")!=null&&session.getAttribute("panteng").equals("anteng")){
        	filterChain.doFilter(httpServletRequest,httpServletResponse);
        	return;
        }else {
        	if(session.getAttribute("panteng")==null){
        		filterChain.doFilter(httpServletRequest,httpServletResponse);
            	return;
        	}
        	httpServletResponse.getWriter().println("xxxxxxxxxxxxxxxxxxxxxxx");
		}
        
    }
}
