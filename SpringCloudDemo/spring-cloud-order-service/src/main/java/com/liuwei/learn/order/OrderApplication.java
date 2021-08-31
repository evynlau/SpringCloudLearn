package com.liuwei.learn.order;

import com.liuwei.learn.lbrules.LoadbalancerRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/26 9:20
 * @Package: com.liuwei.learn.order
 * @Modified By：
 * @Description：
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PAYMENT-SERVICE",configuration = LoadbalancerRule.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
