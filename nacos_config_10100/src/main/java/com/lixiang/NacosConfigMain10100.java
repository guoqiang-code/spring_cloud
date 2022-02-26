package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 郭强
 * @version 1.0
 * @date 2022/2/26 23:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain10100 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain10100.class, args);
    }
}
