package com.atguigu.order.service.impl;


import com.alibaba.nacos.shaded.io.grpc.LoadBalancer;
import com.atgui.order.bean.Order;
import com.atgui.product.bean.Product;
import com.atguigu.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName: com.atguigu.order.service.impl
 * @ClaseName: OrderServiceImpl
 * @Description: OrderServiceImpl
 * @Author: zhaoyg
 * @Date: 2025/3/10 14:33
 * @params *@params $
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();
        Product productFromRemote = getProductFromRemoteWithLoadBalanceAnnotation(productId);
        order.setId(1l);
        //总金额
        order.setTotalAmount(productFromRemote.getPrice().multiply(new BigDecimal(productFromRemote.getNum())));
        order.setUserId(userId);
        order.setNickName("zhangsan");
        order.setAddress("地址");
        //查询商品列表
        order.setProductList(Arrays.asList(productFromRemote));
        return order;
    }


    //远程调用基于注解的负载均衡

    private Product getProductFromRemoteWithLoadBalanceAnnotation(Long productId){

        //远程url
        String url = "http://service-product/product/"+productId;

        //发送远程请求
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }




    //远程调用基于负载均衡

    private Product getProductFromRemoteWithLoadBalance(Long productId){

        ServiceInstance choose =  loadBalancerClient.choose("service-product");

        //拼接远程url
        String url = "http://"+choose.getHost()+":"+choose.getPort()+"/product/"+productId;

        log.info("远程请求url:{}",url);
        //发送远程请求
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }

    //远程调用基于服务名

    private Product getProductFromRemote(Long productId){
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance serviceInstance = instances.get(0);

        //拼接远程url
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/"+productId;

        log.info("远程请求url:{}",url);
        //发送远程请求
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }


    private void test(){
        System.out.println("111");
    }

}
