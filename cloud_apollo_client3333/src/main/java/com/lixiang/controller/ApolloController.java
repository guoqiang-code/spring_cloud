package com.lixiang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/16 10:46
 */
@RestController
@Slf4j
public class ApolloController {

    @Value("${sms.enable}")
    private String sms;

    @GetMapping("/apollo/client/params")
    public String getParams() {
        return sms;
    }
}
