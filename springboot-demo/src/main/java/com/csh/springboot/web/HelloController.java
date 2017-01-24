package com.csh.springboot.web;

import com.alibaba.fastjson.JSON;
import com.csh.springboot.HystrixCondetion;
import com.csh.springboot.hystrix.CommandDemo1;
import com.csh.springboot.hystrix.CommandDemo2;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author chenshenghong
 * @version 1.0
 * @created 2017/1/20
 * @time 上午11:01
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String requestId = request.getParameter("request");
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("主线程-1-request-" +requestId, "主线程-1-request-" + requestId + " : 数据 " + Thread.currentThread().getName());
            HystrixCondetion.variableDefault.set(map);
            for (int i = 1; i <= 10; i ++) {
                new CommandDemo1("test---1111111---" + i).execute();
                new CommandDemo2("test---2222222---" + i).execute();
            }
            map = HystrixCondetion.variableDefault.get();
            System.out.println(map);
        } finally {
            context.shutdown();
        }

        return JSON.toJSONString(map);
    }
}
