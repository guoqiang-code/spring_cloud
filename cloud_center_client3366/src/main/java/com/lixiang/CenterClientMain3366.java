package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/16 15:43
 *
 * http://localhost:3366/actuator/refresh  手动请求刷新
 */
@SpringBootApplication
@EnableEurekaClient
public class CenterClientMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(CenterClientMain3366.class, args);
    }
}
