package com.liuwei.learn.hystrix.controller;

import com.liuwei.learn.hystrix.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/31 16:17
 * @Package: com.liuwei.learn.hystrix.controller
 * @Modified By：
 * @Description：
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_handler")
public class OrderController {

    @Resource
    private PaymentFeignService service;

    /**
     * 服务降级
     * 未指定回调方法，采用类默认的全局回调global_handler
     * @param id
     * @return
     */
    @HystrixCommand
    @GetMapping("/consumer/payment/hs/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return service.ok(id);
    }

    /**
     * 服务降级
     * 为使用@HystrixCommand 采用feign接口实现类的回调
     * @see com.liuwei.learn.hystrix.service.PaymentFallbackService
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hs/ok2/{id}")
    public String ok2(@PathVariable("id") Integer id){
        return service.ok(id);
    }

    /**
     * 超时服务降级
     * 降级处理方式方法专属降级回调
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeout_handler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    @GetMapping("/consumer/payment/hs/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        return service.timeout(id);
    }

    /**
     * 服务降级的回调方法
     * @param id
     * @return
     */
    public String timeout_handler(Integer id){
        return "客户端----线程name："+Thread.currentThread().getName()+" --- method timeout_handler,id:"+id+" O(∩_∩)O";
    }

    public String global_handler(){
        return "全局降级处理----线程name："+Thread.currentThread().getName()+" --- method global_handler O(∩_∩)O";
    }
}
