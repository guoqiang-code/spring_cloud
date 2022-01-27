package com.lixiang;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.lixiang.dao")
public class App {

    private static String port;

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        System.out.println("项目运行地址前缀：http://127.0.0.1:"+port+"/"+"\n"
        +"swagger: http://127.0.0.1:"+port+"/swagger-ui.html"+"\n"
        +"bootstrap地址：http://127.0.0.1:"+port+"/doc.html");
    }

    @Value("${server.port}")
    public void getPort(String p){
        port=p;
    }
}
