package com.lixiang.com.lixiang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭强
 * @version 1.0
 * @date 2022/2/26 23:38
 */
@RestController
@RefreshScope//nacos动态刷新
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/get")
    public String get() {
        return configInfo;
    }
}
