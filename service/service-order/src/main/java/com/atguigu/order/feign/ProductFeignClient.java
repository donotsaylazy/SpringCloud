package com.atguigu.order.feign;


import com.atgui.product.bean.Product;
import com.atguigu.order.feign.fallback.ProductFeignClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product",fallback = ProductFeignClientFallBack.class)  //feign 远程调用服务名
public interface ProductFeignClient {



    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long productId);

}
