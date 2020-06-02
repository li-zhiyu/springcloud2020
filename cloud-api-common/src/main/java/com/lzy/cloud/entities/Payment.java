package com.lzy.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Author:lizhiyu
* @Date:下午 1:44 2020-06-01
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    /**
     * 支付流水号
     */
    private String serial;
}
