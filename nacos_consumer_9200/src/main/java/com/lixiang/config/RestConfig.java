package com.lixiang.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @LoadBalanced //必须添加，否则报错
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
