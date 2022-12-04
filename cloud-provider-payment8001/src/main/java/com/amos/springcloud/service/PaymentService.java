package com.amos.springcloud.service;


import com.amos.springcloud.entities.Payment;


public interface PaymentService {

    int create(Payment payment);

    Payment getPayMentById(Long id);

}
