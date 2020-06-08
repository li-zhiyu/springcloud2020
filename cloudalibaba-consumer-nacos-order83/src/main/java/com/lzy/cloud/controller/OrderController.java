package com.lzy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:lizhiyu
 * @Date:2020-06-08 上午 10:59
 */
@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serviceURL+"/payment/nacos/"+id,String.class);
    }
}
