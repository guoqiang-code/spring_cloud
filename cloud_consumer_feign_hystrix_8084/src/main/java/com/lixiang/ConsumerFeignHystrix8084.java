package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 15:24
 */
@SpringBootApplication
@EnableFeignClients
/**
 * @EnableHystrix 和 @EnableCircuitBreaker 两个注解的功能都是用来激活 Hystrix 的功能。
 * 根据 @EnableHystrix 的源码可以发现，它继承了 @EnableCircuitBreaker，并对它进行了在封装。
 *
 * 如果你需要启动 Hystrix 功能，只需要在服务启动类加入 @EnableHystrix 注解即可，
 * 无须增加 @EnableCircuitBreaker 注解，本身 @EnableHystrix 注解已经涵盖了 @EnableCircuitBreaker 的功能。
 */
@EnableHystrix
public class ConsumerFeignHystrix8084 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrix8084.class, args);
    }
}
