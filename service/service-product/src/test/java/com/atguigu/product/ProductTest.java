package com.atguigu.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * @PackageName: com.atguigu
 * @ClaseName: product
 * @Description: product
 * @Author: zhaoyg
 * @Date: 2025/3/10 10:09
 * @params *@params $
 */

@SpringBootTest
public class ProductTest {

    @Autowired
    DiscoveryClient  discoveryClient;

    @Autowired
    NacosServiceDiscovery  nacosServiceDiscovery;



    @Test
    void test(){
        for(String service: discoveryClient.getServices()){
            System.out.println("service  = "+service);

            discoveryClient.getInstances(service).forEach(instance -> {
                System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            });
        }



    }

}
