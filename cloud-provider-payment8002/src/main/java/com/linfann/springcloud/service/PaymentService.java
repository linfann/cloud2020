package com.linfann.springcloud.service;

import com.linfann.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author freya
 * @date 2020/10/2
 **/
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
