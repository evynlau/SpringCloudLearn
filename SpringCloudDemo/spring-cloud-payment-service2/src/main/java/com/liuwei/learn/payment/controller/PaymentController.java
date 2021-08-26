package com.liuwei.learn.payment.controller;

import com.liuwei.learn.bean.CommonResult;
import com.liuwei.learn.payment.entity.Payment;
import com.liuwei.learn.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/25 17:17
 * @Package: com.liuwei.learn.payment.controller
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

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = service.create(payment);
        log.info("controller create payment :"+result);
        return new CommonResult(200,"操作成功,server:"+serverPort,result);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = service.getPaymentById(id);
        log.info("controller getPaymentById :"+payment);
        return new CommonResult(200,"操作成功,server:"+serverPort,payment);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service:services){
            log.info("--------------"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.info("--------------serviceId:"+instance.getServiceId()+
                    "\t--------------instanceId:"+instance.getInstanceId() +
                    "\t--------------host:"+instance.getHost() +
                    "\t--------------port:"+instance.getPort() +
                    "\t--------------uri:"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
