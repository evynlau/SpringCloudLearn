package com.liuwei.learn.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/13 17:36
 * @Package: com.liuwei.learn.stream
 * @Modified By：
 * @Description：
 */
@SpringBootApplication
//注意，springcloud G版之后eureka注释可省略
public class StreamProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplication.class,args);
    }
}
