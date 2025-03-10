package com.atguigu.order;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.atguigu.order
 * @ClaseName: OrderMainApplication
 * @Description: OrderMainApplication
 * @Author: zhaoyg
 * @Date: 2025/2/24 17:18
 * @params *@params $
 */

@EnableDiscoveryClient  //开启服务发现功能
@SpringBootApplication
public class OrderMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }
}
