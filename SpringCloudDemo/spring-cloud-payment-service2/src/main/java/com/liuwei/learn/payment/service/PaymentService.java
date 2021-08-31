package com.liuwei.learn.payment.service;

import com.liuwei.learn.payment.entity.Payment;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/25 17:13
 * @Package: com.liuwei.learn.payment.service
 * @Modified By：
 * @Description：
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
