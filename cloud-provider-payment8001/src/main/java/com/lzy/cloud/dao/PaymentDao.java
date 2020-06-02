package com.lzy.cloud.dao;

import com.lzy.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:lizhiyu
 * @Date:下午 1:55 2020-06-01
 */
@Mapper
public interface PaymentDao {
    /**
     * 新增
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
