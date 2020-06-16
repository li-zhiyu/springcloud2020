package com.lzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:lizhiyu
 * @Date:2020-06-15 下午 4:39
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class OrderServiceMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain2001.class, args);
    }
}
