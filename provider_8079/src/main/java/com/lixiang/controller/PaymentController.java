package com.lixiang.controller;

import com.lixiang.entity.Payment;
import com.lixiang.entity.Result;
import com.lixiang.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.internal.dynalink.support.AutoDiscovery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author GuoQiang
 * @create 2022-01-16 16:46
 */
@Slf4j
@RestController
@Api(value="测试数据",tags = "测试1")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    //服务检测
    @Resource
    private DiscoveryClient discoveryClient;

    @ApiOperation(value="添加")
    @PostMapping("/provider/insert")
    public Result insert(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        Result<Payment> paymentResult = new Result<>(200, "成功,serverPort:");
        return paymentResult;
    }

    @ApiOperation(value="查找")
    @GetMapping("/provider/find/{id}")
    public Result<Payment> findById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        Result<Payment> result = new Result<>(200,"成功,serverPort:"+port,payment);
        return result;
    }

    //服务发现
    @GetMapping("provider/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(log::info);
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRING-CLOUD-PROVIDER");
        instances.forEach(item->log.info(item.getServiceId()+"\t"+item.getHost()+"\t"+item.getPort()+"\t"+item.getUri()));

        return this.discoveryClient;
    }

}
