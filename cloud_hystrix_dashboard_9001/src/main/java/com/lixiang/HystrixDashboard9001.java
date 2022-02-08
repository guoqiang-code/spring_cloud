package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/8 17:34
 */
@SpringBootApplication
/**
 * 开启仪表盘监控，监控的微服务需要spring-boot-starter-actuator的jar包
 */
@EnableHystrixDashboard
public class HystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001.class, args);
    }
}

