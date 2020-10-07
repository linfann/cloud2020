package com.linfann.springcloud.service.impl;

import com.linfann.springcloud.dao.PaymentDao;
import com.linfann.springcloud.entities.Payment;
import com.linfann.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author freya
 * @date 2020/10/2
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
//    @Autowired
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
