package com.liuwei.learn.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/31 16:02
 * @Package: com.liuwei.learn.hystrix.service
 * @Modified By：
 * @Description：
 */
@Component
@FeignClient(value = "PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/api/v1/payment/hs/ok/{id}")
    public String ok(@PathVariable("id") Integer id);

    @GetMapping("/api/v1/payment/hs/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id);
}
