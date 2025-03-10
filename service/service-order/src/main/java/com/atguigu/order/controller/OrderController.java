package com.atguigu.order.controller;

import com.atgui.order.bean.Order;
import com.atguigu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class OrderController {



    @Autowired
    OrderService orderService;


    @GetMapping("/create" )
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId){
        Order order = orderService.createOrder(productId, userId);
        return order;
    }
}
