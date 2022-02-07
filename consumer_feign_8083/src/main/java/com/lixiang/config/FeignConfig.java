package com.lixiang.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 11:11
 */
@Configuration
public class FeignConfig {
    //日志级别
    @Bean
    Logger.Level feignLoggerLervel() {
        return Logger.Level.FULL;
    }
}
