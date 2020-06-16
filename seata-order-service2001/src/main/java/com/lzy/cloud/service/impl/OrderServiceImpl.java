package com.lzy.cloud.service.impl;

import com.lzy.cloud.dao.OrderDao;
import com.lzy.cloud.domain.Order;
import com.lzy.cloud.entities.CommonResult;
import com.lzy.cloud.service.AccountService;
import com.lzy.cloud.service.OrderServie;
import com.lzy.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:lizhiyu
 * @Date:2020-06-15 下午 4:57
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderServie {

    @Autowired
    OrderDao orderDao;

    @Autowired
    AccountService accountService;

    @Autowired
    StorageService storageService;

    @Override
    @GlobalTransactional(name = "create-order")
    public CommonResult createOrder(Order order) {
        //1.创建订单
        orderDao.createOrder(order);
        log.info("创建订单成功");
        //2.减库存
        storageService.decreaseStorage(order.getProductId(),order.getCount());
        log.info("扣减成功");
        //3.减账户余额
        accountService.decreaseAccount(order.getUserId(),order.getMoney());
        log.info("扣减账户");
        //4.更新订单状态为已完成
        order.setStatus(1);
        orderDao.updateOrder(order);
        log.info("订单支付完成");
        return new CommonResult(200,"下单成功");
    }

    @Override
    public CommonResult updateOrder(Order order) {
        orderDao.updateOrder(order);
        return new CommonResult(200,"订单更新成功");
    }
}
