package com.lixiang.controller;

import com.lixiang.entity.Payment;

import com.lixiang.entity.Result;
import com.lixiang.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/25 9:25
 */
@RestController
@Slf4j
public class OrderController {

//    private static final String PROVIDER_URL="http://127.0.0.1:8080";
    private static final String PROVIDER_URL="http://SPRING-CLOUD-PROVIDER";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/consumer/create")
    public Result create(@RequestBody Payment payment){
        return restTemplate.postForObject(PROVIDER_URL+"/provider/insert",payment,Result.class);
    }

    @PostMapping("/consumer/create2")
    public ResponseEntity<Result> create2(@RequestBody Payment payment){
        ResponseEntity<Result> forEntity = restTemplate.postForEntity(PROVIDER_URL + "/provider/insert", payment, Result.class);
        System.err.println(forEntity.getStatusCode()+"\t"+forEntity.getStatusCodeValue()+"\n"+forEntity.getBody()+"\n"+forEntity.getHeaders());
        return forEntity;
    }


    @GetMapping("/consumer/find/{id}")
    public Result<Payment> findById(@PathVariable(value = "id") Long id){
        return restTemplate.getForObject(PROVIDER_URL+"/provider/find/"+id,Result.class);
    }

    @GetMapping("/consumer/find2/{id}")
    public ResponseEntity<Result> findById2(@PathVariable(value = "id") Long id){
        ResponseEntity<Result> forEntity = restTemplate.getForEntity(PROVIDER_URL + "/provider/find/" + id, Result.class);
        log.error(forEntity.getStatusCode()+"\t"+forEntity.getStatusCodeValue()+"\n"+forEntity.getBody()+"\n"+forEntity.getHeaders());
        return forEntity;
    }
    @GetMapping("/consumer/findLB")
    public String getMyLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRING-CLOUD-PROVIDER");
        if(instances==null||instances.size()==0){
            return null;
        }
        ServiceInstance instance=loadBalancer.instances(instances);
        URI uri = instance.getUri();

        System.err.println(uri);

        return restTemplate.getForObject(uri+"provider/getPort",String.class);
    }
}
