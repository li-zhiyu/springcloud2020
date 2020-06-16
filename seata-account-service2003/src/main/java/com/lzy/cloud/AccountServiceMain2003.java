package com.lzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author:lizhiyu
 * @Date:2020-06-16 下午 2:37
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AccountServiceMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceMain2003.class, args);
    }
}
