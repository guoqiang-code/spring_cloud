package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/15 17:17
 *
 * http://localhost:3355/actuator/refresh  手动请求刷新
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient3355Main {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355Main.class, args);
    }
}
