package com.lixiang.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author GuoQiang
 * @create 2022-01-16 16:46
 */

@RestController
public class PaymentController {


    @Value("${server.port}")
    private String port;



    @GetMapping("/provider/consul")
    public  String findConsul() {
        return "spring cloud consul :"+port+"\t"+ UUID.randomUUID();
    }


}
