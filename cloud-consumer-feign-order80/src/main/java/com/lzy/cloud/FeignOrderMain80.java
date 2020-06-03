package com.lzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:lizhiyu
 * @Date:2020-06-03 上午 9:54
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain80.class, args);
    }
}
