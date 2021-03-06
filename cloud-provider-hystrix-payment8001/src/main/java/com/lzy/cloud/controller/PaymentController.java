package com.lzy.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.lzy.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:lizhiyu
 * @Date:2020-06-03 下午 1:53
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("*****result:" + result);
        return result;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result:" + result);
        return result;

    }

    @GetMapping("/payment/hystrix/circuitbreaker/{id}")
    public String paymentInfo_CircuitBreaker(@PathVariable("id") Integer id) {
        if (id<0){
            throw new RuntimeException("*****id不能为负数");
        }
        return Thread.currentThread().getName()+"，请求序列号："+ IdUtil.simpleUUID();

    }

}
