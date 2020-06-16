package com.lzy.cloud.controller;

import com.lzy.cloud.domain.Order;
import com.lzy.cloud.entities.CommonResult;
import com.lzy.cloud.service.OrderServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:lizhiyu
 * @Date:2020-06-15 下午 5:05
 */
@RestController
public class OrderController {

    @Autowired
    OrderServie orderServie;


    @GetMapping(value = "/create/order")
    public CommonResult createOrder(Order order){
        order.setCount(5);
        order.setProductId(1504213654L);
        order.setUserId(180156L);
        order.setStatus(0);
        order.setMoney(32L);
        return orderServie.createOrder(order);
    }

    public CommonResult updateOrder(Order order ){
        return orderServie.updateOrder(order);
    }
}
