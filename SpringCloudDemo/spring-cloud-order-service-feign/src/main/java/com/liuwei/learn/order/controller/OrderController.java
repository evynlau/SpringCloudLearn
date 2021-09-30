package com.liuwei.learn.order.controller;

import com.liuwei.learn.bean.CommonResult;
import com.liuwei.learn.order.entity.Payment;
import com.liuwei.learn.order.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author : LiuWei
 * @Date : Created in 2021/8/27 16:33
 * @Package: com.liuwei.learn.order.controller
 * @Modified By:
 * @Description:
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    PaymentFeignService service;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return service.getPaymentById(id);
    }
}
