package com.csh.springboot;

import com.csh.springboot.filter.HystrixFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;

/**
 * @author chenshenghong
 * @version 1.0
 * @created 2017/1/20
 * @time 下午1:14
 */
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 过滤器配置
     * @return
     */
//    @Bean
//    public FilterRegistrationBean getDemoFilter(){
//        HystrixFilter filter = new HystrixFilter();
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(filter);
//        ArrayList<String> urlPatterns = new ArrayList<>();
//        urlPatterns.add("/*");//拦截路径,可以添加多个
//        registrationBean.setUrlPatterns(urlPatterns);
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }

//    public ServletRegistrationBean getDemoServlet(){}
//public ServletListenerRegistrationBean<EventListener> getDemoListener();
}
