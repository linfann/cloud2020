package com.linfann.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author freya
 * @date 2020/10/10
 **/
@Configuration
public class GateWayConfig{
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder rb){
        RouteLocatorBuilder.Builder routes = rb.routes();
        routes.route("path_route_linfann",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
