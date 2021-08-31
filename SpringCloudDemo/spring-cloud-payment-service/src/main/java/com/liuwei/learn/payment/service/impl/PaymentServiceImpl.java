package com.liuwei.learn.payment.service.impl;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/25 17:13
 * @Package: com.liuwei.learn.payment.service.impl
 * @Modified By：
 * @Description：
 */

import com.liuwei.learn.payment.entity.Payment;
import com.liuwei.learn.payment.repository.PaymentMapper;
import com.liuwei.learn.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper mapper;

    @Override
    public int create(Payment payment) {
        return mapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return mapper.getPaymentById(id);
    }
}
