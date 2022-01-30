package com.lixinag.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author GuoQiang
 * @create 2022-01-16 16:46
 */

@RestController
public class PaymentController {


    @Value("${server.port}")
    private String port;

    private static final String PROVIDER_URL="http://consul-cloud-provider";



    @GetMapping("/consumer/consul")
    public  String findConsul() {
        return "spring cloud consul :"+port+"\t"+"URL: "+PROVIDER_URL+"\t"+ UUID.randomUUID();
    }


}
