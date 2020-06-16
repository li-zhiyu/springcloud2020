package com.lzy.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 库存(TStorage)实体类
 *
 * @author makejava
 * @since 2020-06-16 09:38:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 920538084184353463L;
    
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 总额
    */
    private Integer total;
    /**
    * 已用
    */
    private Integer used;
    /**
    * 剩余
    */
    private Integer residue;

}