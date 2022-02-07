package com.lixiang.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 15:28
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX")
public interface PaymentHystrixFeignService {

    @GetMapping("/provider/hystrix/info/{id}")
    public String providerInfo(@PathVariable("id") Integer id);

    @GetMapping("/provider/hystrix/info-timeout/{id}")
    public String providerInfoTimeout(@PathVariable("id") Integer id);
}
