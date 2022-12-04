package com.amos.springcloud.service.impl;

import com.amos.springcloud.dao.PaymentDao;
import com.amos.springcloud.entities.Payment;
import com.amos.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPayMentById(Long id) {
        return paymentDao.getPayMentById(id);
    }
}
