package com.linfann.springcloud.controller;

import com.linfann.springcloud.entities.CommonResult;
import com.linfann.springcloud.entities.Payment;
import com.linfann.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author freya
 * @date 2020/10/2
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        System.out.println("*****插入结果：" + result);
        log.info("*****");
        if(result>0){
            return new CommonResult(200,"插入数据库成功,serverPort = " + serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("******查询结果" + payment);
        log.info("*****");
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort = " + serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录，查询失败 " + id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****element: " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "/t" + instance.getPort() + "/t" + instance.getUri());
        }
        return discoveryClient;
    }

}
