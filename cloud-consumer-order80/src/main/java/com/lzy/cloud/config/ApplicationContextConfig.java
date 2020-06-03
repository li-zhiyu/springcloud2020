package com.lzy.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:lizhiyu
 * @Date:下午 2:20 2020-06-01
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //使用自定义负载均衡规则
    //@LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
