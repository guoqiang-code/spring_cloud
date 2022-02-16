package com.lixiang;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/16 10:45
 */
@SpringBootApplication
@EnableEurekaClient
@EnableApolloConfig
//文档链接 https://li.feishu.cn/docs/doccnL9ABHLPpTwpR6DCyMQoKCh#h9ma8S
public class ApolloClientMain3333 {
    public static void main(String[] args) {
        SpringApplication.run(ApolloClientMain3333.class, args);
    }
}
