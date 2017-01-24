package com.csh.springboot.hystrix;

import com.csh.springboot.HystrixCondetion;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

import java.util.Map;

/**
 * @author chenshenghong
 * @version 1.0
 * @created 2017/1/20
 * @time 下午12:08
 */
public class CommandDemo2 extends HystrixCommand<String> {

    private final String requestId;

    public CommandDemo2(String requestId) {
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("springboot"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(50)));
        this.requestId = requestId;
    }

    protected String run() throws Exception {
        Map<String, Object> map = HystrixCondetion.variableDefault.get();
        map.put("CommandDemo2-1-request-" +requestId, "CommandDemo2-1-request-" + requestId + " : 数据 " + Thread.currentThread().getName());
        HystrixCondetion.variableDefault.set(map);
        return requestId;
    }
}
