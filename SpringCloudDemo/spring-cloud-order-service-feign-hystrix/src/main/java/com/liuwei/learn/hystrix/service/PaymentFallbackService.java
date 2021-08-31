package com.liuwei.learn.hystrix.service;

import org.springframework.stereotype.Component;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/31 17:09
 * @Package: com.liuwei.learn.hystrix.service
 * @Modified By：
 * @Description：
 */
@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public String ok(Integer id) {
        return "PaymentFallbackService#ok() 降级处理";
    }

    @Override
    public String timeout(Integer id) {
        return "PaymentFallbackService#timeout() 降级处理";
    }
}
