package com.lzy.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 库存(TStorage)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-16 09:38:40
 */
@Mapper
public interface StorageDao {


    int decreaseStorage(@Param("productId") Long productId,@Param("count") Integer count);

}