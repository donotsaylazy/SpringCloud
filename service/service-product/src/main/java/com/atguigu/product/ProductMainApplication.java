package com.atguigu.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.atguigu.product
 * @ClaseName: ProductMainApplication
 * @Description: ProductMainApplication
 * @Author: zhaoyg
 * @Date: 2025/3/10 9:53
 * @params *@params $
 */
@EnableDiscoveryClient  //开启服务发现功能
@SpringBootApplication
public class ProductMainApplication {

    public static void main(String[] args) {
      SpringApplication.run(ProductMainApplication.class, args);
    }
}
