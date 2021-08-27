package com.liuwei.learn.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/26 9:31
 * @Package: com.liuwei.learn.order.config
 * @Modified By：
 * @Description：
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
