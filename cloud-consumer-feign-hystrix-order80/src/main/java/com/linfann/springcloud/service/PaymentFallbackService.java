package com.linfann.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author freya
 * @date 2020/10/7
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "*****PaymentFallbackService fall back-paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "********PaymentFallbackService fall back-paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}
