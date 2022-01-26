package com.lixiang.controller;

import com.lixiang.entity.Payment;
import com.lixiang.res.Result;
import com.lixiang.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Result insert(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        return Result.success();
    }

    @ApiOperation(value="查找")
    @GetMapping("/provider/find/{id}")
    public Result<Payment> findById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        return Result.success(payment);
    }
}
