package com.lixiang.controller;

import com.lixiang.entity.Payment;
import com.lixiang.entity.Result;
import com.lixiang.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author GuoQiang
 * @create 2022-01-16 16:46
 */
@Slf4j
@RestController
@Api(value = "测试数据", tags = "测试1")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @ApiOperation(value = "添加")
    @PostMapping("/provider/insert")
    public Result insert(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        Result<Payment> paymentResult = new Result<>(200, "成功,serverPort:" + port, payment);
        return paymentResult;
    }

    @ApiOperation(value = "查找")
    @GetMapping("/provider/find/{id}")
    public Result<Payment> findById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        Result<Payment> result = new Result<>(200, "成功,serverPort:" + port, payment);
        return result;
    }

    @GetMapping("/provider/getPort")
    public String getPort() {
        return port;
    }

    @GetMapping("/provider/feign/timeout")
    public String feignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping("/provider/zipkin")
    public String getZipKin() {
        return "zipkin~~~~~port:" + port;
    }
}
