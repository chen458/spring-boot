package com.csh.springboot.hystrix;

import com.csh.springboot.HystrixCondetion;
import com.netflix.hystrix.*;

import java.util.Map;

/**
 * @author chenshenghong
 * @version 1.0
 * @created 2017/1/20
 * @time 下午12:03
 */
public class CommandDemo1 extends HystrixCommand<String> {
    private final String requestId;

    public CommandDemo1(String requestId) {
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("springboot"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(50)));
        this.requestId = requestId;
    }

    protected String run() throws Exception {
        Map<String, Object> map = HystrixCondetion.variableDefault.get();
        map.put("CommandDemo1-1-request-" +requestId, "CommandDemo1-1-request-" + requestId + " : 数据 " + Thread.currentThread().getName());
        HystrixCondetion.variableDefault.set(map);
        return requestId;
    }
}
