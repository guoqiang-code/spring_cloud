package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/30 9:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider8090 {
    public static void main(String[] args) {
        SpringApplication.run(Provider8090.class, args);
    }
}
