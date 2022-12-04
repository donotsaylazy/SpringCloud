package com.amos.springcloud.dao;

import com.amos.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPayMentById(@Param("id") Long id);


}
