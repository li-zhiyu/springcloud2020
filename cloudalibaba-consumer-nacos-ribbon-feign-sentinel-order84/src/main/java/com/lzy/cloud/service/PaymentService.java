package com.lzy.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author:lizhiyu
 * @Date:2020-06-12 上午 11:34
 */
@Service
@FeignClient(value = "nacos-provider-payment")
public interface PaymentService {

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id);
}
