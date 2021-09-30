package com.liuwei.learn.hystrix.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/31 16:21
 * @Package: com.liuwei.learn.hystrix.config
 * @Modified By:
 * @Description:
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
//        return Logger.Level.NONE; //默认，不显示日志
//        return Logger.Level.BASIC;  //显示请求方法，url，响应状态及时间
//        return Logger.Level.HEADERS;  //BASIC + 请求和响应头信息
        return Logger.Level.FULL;  // All
    }
}