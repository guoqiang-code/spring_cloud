package com.lixiang.controller;

import com.lixiang.entity.Payment;

import com.lixiang.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/25 9:25
 */
@RestController
@Slf4j

public class OrderController {

//    private static final String PROVIDER_URL="http://127.0.0.1:8080";
    private static final String PROVIDER_URL="http://SPRING-CLOUD-PROVIDER";
    @Resource
    private RestTemplate restTemplate;


    @PostMapping("/consumer/create")
    public Result create(@RequestBody Payment payment){
        return restTemplate.postForObject(PROVIDER_URL+"/provider/insert",payment,Result.class);
    }


    @GetMapping("/consumer/find/{id}")
    public Result<Payment> findById(@PathVariable(value = "id") Long id){
        return restTemplate.getForObject(PROVIDER_URL+"/provider/find/"+id,Result.class);
    }
}
