package com.liuwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/25 14:40
 * @Package: com.liuwei
 * @Modified By：
 * @Description：
 */
@SpringBootApplication
@EnableOpenApi
@EnableSwagger2
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
