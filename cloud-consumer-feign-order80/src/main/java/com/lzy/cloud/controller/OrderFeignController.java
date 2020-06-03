package com.lzy.cloud.controller;

import com.lzy.cloud.entities.CommonResult;
import com.lzy.cloud.entities.Payment;
import com.lzy.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:lizhiyu
 * @Date:2020-06-03 上午 9:56
 */
@RestController
public class OrderFeignController {
    @Autowired
    PaymentFeignService paymentFeignService;

    /**
     * http://localhost/consumer/payment/get/31
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
