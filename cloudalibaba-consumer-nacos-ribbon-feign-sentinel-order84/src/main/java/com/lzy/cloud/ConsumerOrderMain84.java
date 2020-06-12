package com.lzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:lizhiyu
 * @Date:2020-06-12 上午 11:28
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerOrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain84.class, args);
    }
}
