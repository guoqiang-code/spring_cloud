package com.lixiang.controller;

import com.lixiang.service.MsgProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/16 18:26
 */
@RestController
public class SendMsgController {

    @Resource
    private MsgProvider msgProvider;

    @GetMapping("/getMsg")
    public String send() {
        return msgProvider.send();
    }
}
