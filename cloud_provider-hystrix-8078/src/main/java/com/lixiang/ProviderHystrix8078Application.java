package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
/**
 * 断路器
 *
 * @EnableCircuitBreaker主要是为了加载HystrixCircuitBreakerConfiguration以及HystrixCommandAspect，
 * 通过AOP代理我们的方法，熔断、限流，就是在这里开始的。
 */
@EnableCircuitBreaker
public class ProviderHystrix8078Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrix8078Application.class, args);
    }

}
