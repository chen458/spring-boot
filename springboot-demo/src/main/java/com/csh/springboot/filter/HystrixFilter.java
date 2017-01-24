package com.csh.springboot.filter;

import com.alibaba.fastjson.JSON;
import com.csh.springboot.HystrixCondetion;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenshenghong
 * @version 1.0
 * @created 2017/1/20
 * @time 下午1:06
 */
public class HystrixFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            String sr = servletRequest.getParameter("request");
            Map<String, Object> map = new HashMap<>();
            map.put("主线程-1-request-" +sr, "主线程-1-request-" + sr + " : 数据 " + Thread.currentThread().getName());
            HystrixCondetion.variableDefault.set(map);
            //执行主流程
            filterChain.doFilter(servletRequest, servletResponse);

        } finally {

        }
    }

    @Override
    public void destroy() {

    }
}
