package com.lzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author:lizhiyu
 * @Date:2020-06-16 上午 9:33
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StorageServiceMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StorageServiceMain2002.class, args);
    }
}
