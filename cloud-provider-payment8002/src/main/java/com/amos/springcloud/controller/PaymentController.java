package com.amos.springcloud.controller;


import com.amos.springcloud.entities.CommentResult;
import com.amos.springcloud.entities.Payment;
import com.amos.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentServiceImpl;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommentResult create(@RequestBody Payment payment){
        int i = paymentServiceImpl.create(payment);
        return new CommentResult(200,"插入数据成功"+serverPort,i);
    }

    @GetMapping("/payment/get/{id}")
    public CommentResult  getPaymentById(@PathVariable("id") Long id){
        Payment payMentById = paymentServiceImpl.getPayMentById(id);
        return new CommentResult(200,"查询成功"+serverPort,payMentById);
    }
}
