package com.linfann.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author freya
 * @date 2020/10/5
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level FeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
