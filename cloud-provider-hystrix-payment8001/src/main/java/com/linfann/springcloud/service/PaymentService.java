package com.linfann.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author freya
 * @date 2020/10/6
 **/
public interface PaymentService {
    String paymentInfo_OK(Integer id);
    String paymentInfo_TimeOUt(Integer id);
    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
