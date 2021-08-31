package com.liuwei.learn.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/25 16:49
 * @Package: com.liuwei.learn.payment.entity
 * @Modified By：
 * @Description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
