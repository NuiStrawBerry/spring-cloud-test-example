package com.jonas.two.config;

import com.jonas.two.filter.HttpBasicAuthorizeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        HttpBasicAuthorizeFilter filter = new HttpBasicAuthorizeFilter();
        filterRegistrationBean.setFilter(filter);
        List<String> urlPatterns = new ArrayList<>(1);
        urlPatterns.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
