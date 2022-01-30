package com.lixiang;

import com.chj.rule.NetflixRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/19 12:59
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
/**
 * 可改变ribbon的随机访问，注意：引入jar包spring-cloud-starter-netflix-eureka-client时会自己注入
 * spring-cloud-starter-netflix-ribbon的jar包，前提：版本一定要在spring-cloud-starter-netflix-eureka-client
 *  <version>2.2.3.RELEASE</version>及之前，否则不再带入需要的ribbon jar包，需要自己引入jar包，一定注意版本适配，否则将报出 找不到实例的错
 */
@RibbonClient(name = "SPRING-CLOUD-PROVIDER",configuration = NetflixRule.class)
public class Consumer8081 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8081.class, args);
    }

}
