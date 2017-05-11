package com.site.panteng.config;

import com.site.panteng.filter.MyFilter;
import com.site.panteng.filter.PermissionsFilter;
import com.site.panteng.filter.SqlFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by panteng on 2017/4/8.
 */
@Configuration
public class FilterConfig {
    //记录IP
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(getFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    //SQL拦截
    @Bean
    public FilterRegistrationBean sqlFileter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new SqlFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    //权限控制
    @Bean
    public FilterRegistrationBean permissionFileter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new PermissionsFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(3);
        return filterRegistrationBean;
    }

    @Bean
    public MyFilter getFilter() {
        return new MyFilter();
    }
}
