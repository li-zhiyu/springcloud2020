package com.lzy.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lzy.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:lizhiyu
 * @Date:2020-06-12 上午 11:31
 */
@RestController
public class TestController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/payment/nacos/{id}")
    @SentinelResource(value = "paymentNacos", blockHandler = "dealException")
    public String getPaymentInfo(@PathVariable("id") Integer id){
        return paymentService.getPayment(id);
    }

    public String dealException(Integer id){
        return "自定义异常处理";
    }

}
