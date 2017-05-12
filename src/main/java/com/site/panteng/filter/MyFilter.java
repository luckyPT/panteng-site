package com.site.panteng.filter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by panteng on 2017/4/8.
 */
public class MyFilter extends OncePerRequestFilter {
    private static Logger logger = Logger.getLogger(MyFilter.class);

    static {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/webapps/WEB-INF/classes/log4j.properties");
    }

    /**
     * 统计记录
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        logger.info("访问统计 " + httpServletRequest.getRemoteAddr() + " url = " + httpServletRequest.getRequestURL());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
