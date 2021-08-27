package com.liuwei.learn.order.service;

import com.liuwei.learn.bean.CommonResult;
import com.liuwei.learn.order.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/27 16:29
 * @Package: com.liuwei.learn.order.service
 * @Modified By：
 * @Description：
 */
@Component
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/api/v1/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
