package com.lzy.cloud.service;

import com.lzy.cloud.domain.Order;
import com.lzy.cloud.entities.CommonResult;

/**
 * @Author:lizhiyu
 * @Date:2020-06-15 下午 4:55
 */
public interface OrderServie {

    CommonResult createOrder(Order order);

    CommonResult updateOrder(Order order);

}
