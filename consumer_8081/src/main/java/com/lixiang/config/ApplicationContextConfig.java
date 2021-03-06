package com.lixiang.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/25 9:23
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    /**
     * 开启负载均衡，默认是轮询
     */
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
