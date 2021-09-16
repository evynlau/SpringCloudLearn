package com.liuwei.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/16 14:14
 * @Package: com.liuwei.learn
 * @Modified By：
 * @Description：zk接口调用学习
 */
@SpringBootApplication
@EnableOpenApi
public class ZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperApplication.class,args);
    }
}
