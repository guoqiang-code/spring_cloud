package com.lixiang.controller;

import com.lixiang.entity.Payment;
import com.lixiang.res.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
@Api(value="消费者",tags = "消费者")
public class OrderController {

    private static final String PROVIDER_URL="http://127.0.0.1:8080";
    @Resource
    private RestTemplate restTemplate;

    @ApiOperation(value="添加")
    @PostMapping("/consumer/create")
    public Result create(@RequestBody Payment payment){
        return restTemplate.postForObject(PROVIDER_URL+"/provider/insert",payment,Result.class);
    }

    @ApiOperation(value="查询")
    @GetMapping("/consumer/find/{id}")
    public Result<Payment> findById(@PathVariable(value = "id") Long id){
        return restTemplate.getForObject(PROVIDER_URL+"/provider/find/"+id,Result.class);
    }
}
