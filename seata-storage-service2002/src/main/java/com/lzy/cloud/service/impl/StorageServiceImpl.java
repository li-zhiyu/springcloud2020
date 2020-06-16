package com.lzy.cloud.service.impl;

import com.lzy.cloud.dao.StorageDao;
import com.lzy.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:lizhiyu
 * @Date:2020-06-16 上午 9:44
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageDao storageDao;

    @Override
    public int decreaseStorage(Long productId,Integer count) {
        log.info("扣库存成功");
        return storageDao.decreaseStorage(productId,count);
    }
}
