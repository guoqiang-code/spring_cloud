package com.lixiang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/15 17:25
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String config;

    @GetMapping("/configInfo")
    public String getInfo() {
        return config;
    }

    @GetMapping("/hello")
    public String getHelloWorld() {
        return "helloworld";
    }
}
