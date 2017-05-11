package com.site.panteng.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author panteng
 * @description
 * @date 17-5-11.
 */
public class SqlFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //首先判断URL中是否含有非法字符
        String url = httpServletRequest.getRequestURL().toString();
        if (url.indexOf("panteng/addArticle") > -1) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        if (sqlValidate(url)) {
            throw new IOException("您发送请求中的参数中含有非法字符");
        }
        //获得所有请求参数名
        Enumeration params = httpServletRequest.getParameterNames();
        String sql = "";
        while (params.hasMoreElements()) {
            //得到参数名
            String name = params.nextElement().toString();
            //得到参数对应值
            String[] value = httpServletRequest.getParameterValues(name);
            for (int i = 0; i < value.length; i++) {
                sql = sql + value[i];
            }
        }

        if (sqlValidate(sql)) {
            throw new IOException("您发送请求中的参数中含有非法字符");
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        System.out.println("==========SQLFilter=============");
    }

    //效验
    protected static boolean sqlValidate(String str) {
        str = str.toLowerCase();//统一转为小写
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +
                "char|declare|sitename|net user|xp_cmdshell|;|+|,|like'|and|exec|execute|insert|create|drop|" +
                "table|from|grant|use|group_concat|column_name|" +
                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +
                "chr|mid|master|truncate|char|declare| or |--|+|,|like|%|#";//过滤掉的sql关键字，可以手动添加
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                System.out.println("=========bad str:" + badStrs[i]);
                return true;
            }
        }
        return false;
    }
}
