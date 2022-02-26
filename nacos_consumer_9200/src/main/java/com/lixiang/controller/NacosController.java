package com.lixiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosController {
    private final RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    private static final String URL = "http://nacos-provider-server";

    @Value("${service-url.nacos-user-service}")
    private String configUrl;

    @Autowired
    public NacosController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @RequestMapping(value = "/nacos/consumer/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
//        return restTemplate.getForObject(URL + "/nacos/provider/" + str, String.class);
        return restTemplate.getForObject(configUrl + "/nacos/provider/" + str + "\t消费者port:" + port+"\t生产者port:", String.class);
    }
}
