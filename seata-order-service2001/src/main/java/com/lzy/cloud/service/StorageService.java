package com.lzy.cloud.service;

import com.lzy.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:lizhiyu
 * @Date:2020-06-15 下午 5:00
 */
@Service
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/decrease/storage")
    CommonResult decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
