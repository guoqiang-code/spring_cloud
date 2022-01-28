package com.lixiang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/19 12:59
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class Consumer8081 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8081.class, args);
    }

}
