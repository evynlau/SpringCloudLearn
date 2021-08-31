package com.liuwei.learn.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/25 15:10
 * @Package: com.liuwei.learn.payment
 * @Modified By：
 * @Description：
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class,args);
    }
}
