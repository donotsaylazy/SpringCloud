package com.amos.springcloud.controller;

import com.amos.springcloud.entities.CommentResult;
import com.amos.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //public final static String PAYMENT_URL="http://localhost:8001";
    public final static String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommentResult create(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommentResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id ) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommentResult.class);
    }

}
