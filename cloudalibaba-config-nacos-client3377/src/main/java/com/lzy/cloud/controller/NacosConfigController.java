package com.lzy.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:lizhiyu
 * @Date:2020-06-08 下午 1:49
 */
@RestController
@RefreshScope
public class NacosConfigController {

    @Value("${config.info}")
    private String ConfigInfo;

    @GetMapping(value = "/config/info")
    public String getConfigInfo(){
        return ConfigInfo;

    }
}
