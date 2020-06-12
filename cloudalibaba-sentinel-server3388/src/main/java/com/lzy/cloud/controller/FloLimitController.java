package com.lzy.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lzy.cloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author:lizhiyu
 * @Date:2020-06-10 下午 5:50
 */
@RestController
public class FloLimitController {

    @GetMapping(value = "/testA")
    public String testA(){
        return "testA";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        return "testB";
    }


    @GetMapping(value = "/testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testC";
    }

    @GetMapping(value = "/testD")
    public String testD(){

        int a=10/0;
        return "testC";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){

        return "testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exp){

        return "dealTestHotKey";
    }


    @GetMapping(value = "/testE")
    @SentinelResource(value = "testE",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public String testE(){

        return "testE";
    }

}
