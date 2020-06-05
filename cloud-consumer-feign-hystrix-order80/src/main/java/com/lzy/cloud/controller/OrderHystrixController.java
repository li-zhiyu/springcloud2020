package com.lzy.cloud.controller;

import com.lzy.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
@DefaultProperties(defaultFallback = "DefaultTimeoutHandler")
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
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeoutHandler",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")//超时，会进行服务降级
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int a=10/0;//运行异常，会进行服务降级
        return paymentFeignService.paymentInfo_TimeOut(id);
    }

    @GetMapping("/consumer/payment/hystrix/circuitbreaker/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
    })//在10秒内10次请求中如果有超过6次请求失败，那么在第11次开始断路器断开，后面连续10s内所有请求都拒绝，10s过后再尝试放行一次，如果成功，断路器闭合，否则继续断开
    public String paymentInfo_circuitbreaker(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_CircuitBreaker(id);
    }

    public String timeoutHandler(Integer id){
        return "服务繁忙请稍后再试..."+id;
    }

    public String DefaultTimeoutHandler(){
        return "(默认全局)服务繁忙请稍后再试...";
    }
}
