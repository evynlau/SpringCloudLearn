package com.liuwei.learn.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/27 11:11
 * @Package: com.liuwei.learn.order
 * @Modified By：
 * @Description：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
