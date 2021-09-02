package com.liuwei.learn.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/2 16:51
 * @Package: com.liuwei.learn.gateway.filter
 * @Modified By：
 * @Description：
 */
@Component
@Slf4j
public class CustomerGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("into filter -----------");
        String userId = exchange.getRequest().getQueryParams().getFirst("userId");
        /*
        业务判断
         */
        if(userId == null){
            log.info("userId is null");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
