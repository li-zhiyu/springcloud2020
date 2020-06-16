package com.lzy.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:lizhiyu
 * @Date:2020-06-15 下午 4:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private Long money;
    private Integer status;//订单状态：0-创建中，1-已完成
}
