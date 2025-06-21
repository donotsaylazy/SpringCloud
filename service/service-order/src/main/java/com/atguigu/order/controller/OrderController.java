package com.atguigu.order.controller;

import com.atgui.order.bean.Order;
import com.atguigu.order.properties.OrderProperties;
import com.atguigu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.atguigu.order.controller
 * @ClaseName: OrderController
 * @Description: OrderController
 * @Author: zhaoyg
 * @Date: 2025/3/10 14:26
 * @params *@params $
 */
//@RefreshScope
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @Autowired
    OrderProperties orderProperties;

    @GetMapping("/getconfig")
    public String getConfig() {
        return "orderTimeout:" + orderProperties.getTimeout() + "——orderAutoConfirm:" + orderProperties.getAutoConfirm();
    }

    @GetMapping("/create" )
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId){
        Order order = orderService.createOrder(productId, userId);
        return order;
    }
}
