package com.liuwei.learn.order.controller;

import com.liuwei.learn.bean.CommonResult;
import com.liuwei.learn.order.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/26 9:27
 * @Package: com.liuwei.learn.order.controller
 * @Modified By：
 * @Description：
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://PAYMENT-SERVICE/api/v1";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


    @GetMapping("/consumer/payment/entity/create")
    public CommonResult<Payment> createWithPostEntity(Payment payment){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        log.info("restTemplate#postForEntity()  statusCode: "+entity.getStatusCode());
        return entity.getBody();
    }

    @GetMapping("/consumer/payment/entity/get/{id}")
    public CommonResult<Payment> getPaymentByIdWithGetEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        log.info("restTemplate#getForEntity()  statusCode: "+entity.getStatusCode());
        return entity.getBody();
    }
}
