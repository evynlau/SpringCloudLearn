package com.liuwei.learn.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/1 17:05
 * @Package: com.liuwei.learn.hystrixdashboard
 * @Modified By：
 * @Description：
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixAppliction {
    public static void main(String[] args) {
        SpringApplication.run(HystrixAppliction.class,args);
    }
}
