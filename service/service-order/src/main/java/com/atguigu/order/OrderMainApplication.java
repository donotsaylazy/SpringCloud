package com.atguigu.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @PackageName: com.atguigu.order
 * @ClaseName: OrderMainApplication
 * @Description: OrderMainApplication
 * @Author: zhaoyg
 * @Date: 2025/2/24 17:18
 * @params *@params $
 */

@EnableFeignClients //开启远程调用功能
@EnableDiscoveryClient  //开启服务发现功能
@SpringBootApplication
public class OrderMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }


    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager  nacosConfigManager){
        return args -> {
            ConfigService configService = nacosConfigManager.getConfigService();
            configService.addListener("service-order.properties", "DEFAULT_GROUP", new Listener() {
                @Override
                public Executor getExecutor() {
                    return Executors.newFixedThreadPool(2);
                }

                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("变化的配置信息: " + configInfo);
                }
            });

            System.out.println("OrderMainApplication.applicationRunner start==============");
        };
    };

}
