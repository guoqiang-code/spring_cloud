package com.lixiang.controller;

import com.lixiang.entity.Payment;
import com.lixiang.entity.Result;
import com.lixiang.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 10:28
 */
@Slf4j
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService feignService;

    @GetMapping("/consumer/feign/find/{id}")
    public Result<Payment> getFeignPayment(@PathVariable Long id) {
        return feignService.findById(id);
    }

    @GetMapping("/consumer/feign/timeout")
    public String feignTimeOut() {
        return feignService.feignTimeout();
    }
}
