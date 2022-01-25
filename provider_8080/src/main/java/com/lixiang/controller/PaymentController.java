package com.lixiang.controller;

import com.lixiang.entity.Payment;
import com.lixiang.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @ApiOperation(value="添加")
    @PostMapping("/provider/insert")
    public int insert(@RequestBody Payment payment) {
        return paymentService.insert(payment);
    }

    @ApiOperation(value="查找")
    @PostMapping("/provider/findById")
    public Payment findById(@RequestBody Long id) {
        return paymentService.selectByPrimaryKey(id);
    }
}
