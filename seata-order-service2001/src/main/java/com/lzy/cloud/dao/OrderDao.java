package com.lzy.cloud.dao;

import com.lzy.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:lizhiyu
 * @Date:2020-06-15 下午 4:46
 */
@Mapper
public interface OrderDao {

    Integer createOrder(Order order);

    Integer updateOrder(Order order);

}
