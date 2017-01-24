package com.csh.springboot;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

import java.util.Map;

/**
 * @author chenshenghong
 * @version 1.0
 * @created 2017/1/20
 * @time 上午11:55
 */
public class HystrixCondetion {

    public final static HystrixRequestVariableDefault<Map<String, Object>> variableDefault = new HystrixRequestVariableDefault<Map<String, Object>>();
}
