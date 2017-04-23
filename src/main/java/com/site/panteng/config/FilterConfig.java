package com.site.panteng.config;

import com.site.panteng.filter.MyFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by panteng on 2017/4/8.
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(getFilter());
        filterRegistrationBean.addUrlPatterns("/");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public MyFilter getFilter(){
        return new MyFilter();
    }
}
