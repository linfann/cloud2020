package com.linfann.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author freya
 * @date 2020/10/2
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //赋予restTemplate负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
