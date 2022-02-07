package com.lixiang.controller;

import com.lixiang.service.PaymentHystrixFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 15:31
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderController {

    @Resource
    private PaymentHystrixFeignService service;

    @GetMapping("/consumer/hystrix/info/{id}")
    public String providerInfo(@PathVariable("id") Integer id){
        return service.providerInfo(id);
    };

    /**
     *和提供者相同的配置
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @HystrixCommand
    @GetMapping("/consumer/hystrix/info-timeout/{id}")
    public String providerInfoTimeout(@PathVariable("id") Integer id){
        return service.providerInfoTimeout(id);
    };

    public String paymentInfoTimeoutHandler(Integer id) {
        return "调用支付接口失败：" +"\t" + "(ㄒoㄒ)~~~~系统忙";
    }

    public  String globalFallbackMethod(){
        return "全局连接超时调用~~~~~~~`(*>﹏<*)′";
    }
}
