package com.lzy.cloud.service;

import com.lzy.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author:lizhiyu
 * @Date:2020-06-03 上午 9:56
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
    * Feign通过服务绑定接口来实现注解声明式Http调用，从而优雅而简单的实现了服务调用
     * 相当于Ribbon+restTemplate的再一次封装
     */

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);


    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
