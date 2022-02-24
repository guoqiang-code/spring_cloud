package com.lixiang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/17 15:07
 */
@RestController
public class ConsumerController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumerMsg")
    public String consumerMsg() {
        return "消费者端口号：" + serverPort;
    }
}
