package com.lixiang.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lixiang.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 14:00
 */
@Service
@DefaultProperties(threadPoolKey = "paymentInfoTimeoutHandler")
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String providerInfo(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " providerInfo, id:" + id + "\t" + "O(n_n)O哈哈哈~";
    }

    @Override
    /**
     * fallbackMethod 服务降级 当前接口出现问题时，由fallbackMethod指定的方法代替，避免服务宕机
     * //当接口出现错误时同样适用
     * HystrixProperty 规定在指定时间内响应属于正常现象，超时才走指定的代替方法。
     *
     * 需要主启动类的@EnableCircuitBreaker注解激活
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String providerInfoTimeout(Integer id) {
//        int idnex = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " providerInfo, id:" + id + "\t" + "O(n_n)O哈哈哈~~~~~~~耗时5秒";
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "\t paymentInfoTimeoutHandler, id:" + id + "\t" + "(ㄒoㄒ)~~~~系统忙";
    }

//    服务熔断

    @Override
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少次后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数~~~~~~~~/(ㄒoㄒ)/~~");
        }
        String simpleUUID = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t  流水号：" + simpleUUID;
    }


    public String circuitBreakerFallback(Integer id) {
        return "id  不能为负数，请输入正确的值！！~~~~" + id;
    }
}
