package com.lixiang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/14 9:49
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayMain9501 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9501.class, args);
    }
}
