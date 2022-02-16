package com.lixiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/14 17:24
 *
 * http://localhost:3344/main/application-test.yml 测试路径
 *
 *
 * 添加bus后可以一次刷新处处更新
 * http://localhost:3344/actuator/bus-refresh 每个客户端都刷新
 * http://localhost:3344/actuator/bus-refresh/cloud-config-client:3355 指定实例的通知更新
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3344.class, args);
    }
}
