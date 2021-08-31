package com.liuwei.learn.hystrix.controller;

import com.liuwei.learn.hystrix.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/31 16:17
 * @Package: com.liuwei.learn.hystrix.controller
 * @Modified By：
 * @Description：
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeignService service;

    @GetMapping("/consumer/payment/hs/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return service.ok(id);
    }

    @GetMapping("/consumer/payment/hs/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        return service.timeout(id);
    }
}
