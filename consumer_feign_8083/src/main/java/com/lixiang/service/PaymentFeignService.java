package com.lixiang.service;

import com.lixiang.entity.Payment;
import com.lixiang.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 10:22
 */
@Component
/**
 * values是微服务的名称
 */
@FeignClient(value = "spring-cloud-provider")
public interface PaymentFeignService {

    /**
     * 提供者的地址
     * @param id
     * @return
     */
    @GetMapping("/provider/find/{id}")
    public Result<Payment> findById(@PathVariable(value = "id") Long id);

    @GetMapping("/consumer/feign/timeout")
    public String feignTimeout();
}
