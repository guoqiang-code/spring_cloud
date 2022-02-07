package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 10:19
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeign8083 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign8083.class, args);
    }
}
