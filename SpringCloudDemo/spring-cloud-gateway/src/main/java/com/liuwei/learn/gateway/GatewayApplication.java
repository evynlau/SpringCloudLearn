package com.liuwei.learn.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/2 14:56
 * @Package: com.liuwei.learn.gateway
 * @Modified By：
 * @Description：网关
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
