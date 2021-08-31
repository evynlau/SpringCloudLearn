package com.liuwei.learn.hystrix.controller;

import com.liuwei.learn.hystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/31 14:28
 * @Package: com.liuwei.learn.hystrix.controller
 * @Modified By：
 * @Description：
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hs/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return service.isOk(id);
    }

    @GetMapping("/payment/hs/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        return service.timeout(id);
    }
}
