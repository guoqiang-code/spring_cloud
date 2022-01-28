package com.lixiang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/28 9:35
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class Provider8079 {
    public static void main(String[] args) {
        SpringApplication.run(Provider8079.class,args);
    }
}
