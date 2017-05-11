package com.site.panteng.filter;

import com.google.common.base.Strings;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author panteng
 * @description
 * @date 17-5-11.
 */

public class PermissionsFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        UserStatus status = UserStatus.noneLogin;
        String url = httpServletRequest.getRequestURL().toString();
        //判断用户是否登录
        HttpSession session = httpServletRequest.getSession();

        Object userNameObj = session.getAttribute("userName");
        if (userNameObj == null) {//可能是初次登录
            //发表文章权限控制
            if (url.indexOf("editor/newArticle") > -1) {//发表文章
                throw new ServletException("请登录");
            }
        } else {
            String userName = userNameObj.toString();
            System.out.println("userName=" + userName);
            if (!Strings.isNullOrEmpty(userName)) {
                String verify = session.getAttribute(userName).toString();
                if ((userName + userName).equals(verify)) {
                    //已经登录
                    status = UserStatus.login;
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                    return;
                }
            }
            //发表文章权限控制
            if (url.indexOf("editor/newArticle") > -1) {//发表文章
                throw new ServletException("请登录");
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("==========PermissionFilter=============");
    }

    public enum UserStatus {
        login(0),
        noneLogin(1);


        private int num;

        private UserStatus(int i) {
            this.num = i;
        }
    }


}
