package com.lzy.cloud.controller;

import com.lzy.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:lizhiyu
 * @Date:2020-06-03 上午 9:56
 */
@RestController
public class OrderHystrixController {
    @Autowired
    PaymentHystrixService paymentFeignService;

    /**
     * http://localhost/consumer/payment/get/31
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeoutHandler",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        int a=10/0;
        return paymentFeignService.paymentInfo_TimeOut(id);
    }

    public String timeoutHandler(Integer id){
        return "服务繁忙请稍后再试..."+id;
    }
}
