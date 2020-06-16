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
public class Storage implements Serializable {
    private static final long serialVersionUID = 920538084184353463L;
    
    private Long id;
    /**
    * 产品id
    */
    private Long productId;
    /**
    * 总库存
    */
    private Integer total;
    /**
    * 已用库存
    */
    private Integer used;
    /**
    * 剩余库存
    */
    private Integer residue;

}