package com.liuwei.learn.gateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/2 15:28
 * @Package: com.liuwei.learn.gateway.config
 * @Modified By：
 * @Description：
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator custom(RouteLocatorBuilder builder){
       RouteLocatorBuilder.Builder router = builder.routes();
       router.route("path_route_gateway",r -> r
               .path("/forum.php")
               .uri("http://51srm.com")).build();
       router.route("path_route_gateway2",r -> r
               .path("/portal.php")
               .uri("http://51srm.com/portal.php")).build();
       return router.build();
    }
}
