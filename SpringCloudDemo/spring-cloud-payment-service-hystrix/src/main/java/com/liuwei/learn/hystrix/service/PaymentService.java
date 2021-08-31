package com.liuwei.learn.hystrix.service;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/31 14:20
 * @Package: com.liuwei.learn.hystrix.service
 * @Modified By：
 * @Description：
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String isOk(Integer id){
        return "线程name："+Thread.currentThread().getName()+" --- method isOk,id:"+id;
    }

    /**
     * 超时服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeout_handler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String timeout(Integer id){

        //运行异常
//        int age = 10/0;
        //超时异常
        int time = 5;
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "线程name："+Thread.currentThread().getName()+" --- method timeout,id:"+id+" --- 耗时："+time;
    }

    /**
     * 服务降级的回调方法
     * @param id
     * @return
     */
    public String timeout_handler(Integer id){
        return "线程name："+Thread.currentThread().getName()+" --- method timeout_handler,id:"+id+" O(∩_∩)O";
    }
}
