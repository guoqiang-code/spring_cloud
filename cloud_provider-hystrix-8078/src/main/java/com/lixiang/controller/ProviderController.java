package com.lixiang.controller;

import com.lixiang.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 14:04
 */
@RestController
@Slf4j
public class ProviderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/provider/hystrix/info/{id}")
    public String providerInfo(@PathVariable("id") Integer id){
        return paymentService.providerInfo(id);
    };

    @GetMapping("/provider/hystrix/info-timeout/{id}")
    public String providerInfoTimeout(@PathVariable("id") Integer id){
        return paymentService.providerInfoTimeout(id);
    };
}
