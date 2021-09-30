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
 * @Modified By:
 * @Description:
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
    @Bean
    public RouteLocator custom2(RouteLocatorBuilder builder){
       RouteLocatorBuilder.Builder router = builder.routes();
       router.route("path_jd_get_cookie",r -> r
               .path("/passport/**")
               .uri("https://wq.jd.com/passport/**")).build();
       router.route("path_jd_get_cookie2",r -> r
               .path("/myJd/**")
               .uri("https://home.m.jd.com/myJd/**")).build();
       router.route("path_jd_get_cookie3",r -> r
               .path("/user/**")
               .uri("https://plogin.m.jd.com/user/**")).build();
       router.route("path_jd_get_cookie_login",r -> r
               .path("/login/**")
               .uri("https://plogin.m.jd.com/login/**")).build();
       router.route("path_jd_get_cookie4",r -> r
               .path("/favicon.ico")
               .uri("https://home.m.jd.com/favicon.ico")).build();
       return router.build();
    }
}
