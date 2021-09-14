package com.liuwei.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/14 16:52
 * @Package: com.liuwei.learn
 * @Modified By：
 * @Description：
 */
@SpringBootApplication
public class StreamConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication.class,args);
    }
}
