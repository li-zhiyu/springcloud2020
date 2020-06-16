package com.lzy.cloud.controller;

import com.lzy.cloud.entities.CommonResult;
import com.lzy.cloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:lizhiyu
 * @Date:2020-06-16 上午 9:34
 */
@RestController
public class StorageController {

    @Autowired
    StorageService storageService;

    @PostMapping(value = "/decrease/storage")
    public CommonResult decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decreaseStorage(productId, count);
        return new CommonResult(200,"减库存成功");
    }
}
