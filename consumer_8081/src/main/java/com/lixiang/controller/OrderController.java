package com.lixiang.controller;

import com.lixiang.entity.Payment;
import com.lixiang.res.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/25 9:25
 */
@Controller
@Slf4j
@Api(value="消费者",tags = "消费者")
public class OrderController {

    private static final String PROVIDER_URL="http://localhost:8080";
    @Resource
    private RestTemplate restTemplate;

    @ApiOperation(value="添加")
    @PostMapping("/consumer/create")
    public Result<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PROVIDER_URL+"/provider/insert",payment,Result.class);
    }

    @ApiOperation(value="查询")
    @PostMapping("/consumer/findById/{id}")
    public Result<Payment> findById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PROVIDER_URL+"/provider/findById/"+id,Result.class);
    }
}
