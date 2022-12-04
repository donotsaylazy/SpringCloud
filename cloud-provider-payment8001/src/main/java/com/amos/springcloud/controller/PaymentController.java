package com.amos.springcloud.controller;


import com.amos.springcloud.entities.CommentResult;
import com.amos.springcloud.entities.Payment;
import com.amos.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentServiceImpl;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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


    @GetMapping("/payment/discovery")
    public Object  discovery(){
        List<String> services = discoveryClient.getServices();
        for(String s :services){
                log.info("******-"+s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }

        return this.discoveryClient;
    }
}
