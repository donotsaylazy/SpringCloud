package com.atguigu.order.config;


import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @PackageName: com.atguigu.order.config
 * @ClaseName: OrderConfig
 * @Description: OrderConfig
 * @Author: zhaoyg
 * @Date: 2025/3/10 15:36
 * @params *@params $
 */

@Configuration
public class OrderConfig {

    @Bean
    @LoadBalanced //基于注解的负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    //feign日志
    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }

    //feign 请求重试
    @Bean
    Retryer retryer() {
        return new Retryer.Default();
    }
}
