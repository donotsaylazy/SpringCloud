package com.atguigu.order.service;


import com.atgui.order.bean.Order;

public interface OrderService {


    Order createOrder(Long productId, Long userId);
}
