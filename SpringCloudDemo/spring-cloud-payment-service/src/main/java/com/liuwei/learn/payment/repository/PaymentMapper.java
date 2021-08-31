package com.liuwei.learn.payment.repository;

import com.liuwei.learn.payment.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/25 17:01
 * @Package: com.liuwei.learn.payment.repository
 * @Modified By：
 * @Description：
 */
@Mapper
public interface PaymentMapper {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
